package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomView {
    static class Node {
        int data;
        Node left, right;
        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class posData{
        int pos;
        Node node;

        public posData(int pos, Node node) {
            this.pos = pos;
            this.node = node;
        }
    }
    //iterative
    static void bottomView(Node root){
        Map<Integer,Node> map = new TreeMap<>();
        int pos = 0;
        Queue<posData> queue = new LinkedList<>();
        queue.add(new posData(0,root));
        while (!queue.isEmpty()){
            posData temp = queue.poll();
            Node tempNode = temp.node;
            pos = temp.pos;
            map.put(pos,tempNode);
            if(tempNode.left != null){
                queue.add(new posData(pos-1,tempNode.left));
            }
            if(tempNode.right != null){
                queue.add(new posData(pos+1,tempNode.right));
            }
        }
        for(Map.Entry<Integer,Node> map1 : map.entrySet()){
            System.out.print(map1.getValue().data + " ");
        }
    }
    //recursive
    static class levelData{
        int level;
        int data;

        public levelData(int level, int data) {
            this.level = level;
            this.data = data;
        }
    }
    static Map<Integer,levelData> map = new TreeMap<>();
    static void bottomView2(Node root, int dist,int level){

        if(root == null){
            return;
        }
        if(map.get(dist) == null){
            map.put(dist,new levelData(level, root.data));
        }
        else if(level > map.get(dist).level){
            map.put(dist,new levelData(level, root.data));
        }
        bottomView2(root.left,dist-1,level+1);
        bottomView2(root.right,dist+1,level+1);
    }
    static void bottomView2printer(Node root){
        bottomView2(root,0,0);
        for(Map.Entry<Integer,levelData> m : map.entrySet()){
            System.out.print(m.getValue().data + " ");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        bottomView(root);
        System.out.println();
        bottomView2printer(root);
    }
}
