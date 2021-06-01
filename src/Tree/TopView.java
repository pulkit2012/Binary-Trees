package Tree;

import java.util.*;

public class TopView {
    static class Node{
        int data;
        Node left,right;

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
    //Iterative approach
    static void topView(Node root){
        Map<Integer,Node> map = new TreeMap<>();
        int pos = 0;
        Queue<posData> queue = new LinkedList<>();
        queue.add(new posData(0,root));
        while(!queue.isEmpty()){
            posData temp = queue.poll();
            Node tempNode = temp.node;
            pos = temp.pos;
            if(!map.containsKey(pos)){
                map.put(pos,tempNode);
            }
            if(tempNode.left != null){
                queue.add(new posData(pos-1,tempNode.left));
            }
            if(tempNode.right != null){
                queue.add(new posData(pos+1,tempNode.right));
            }
        }
        for(Map.Entry<Integer,Node> m : map.entrySet()){
            System.out.print(m.getValue().data + " ");
        }
    }
    //recursive approach
    static class DistLevel{
        int data;
        int level;

        public DistLevel(int data, int level) {
            this.data = data;
            this.level = level;
        }
    }
    static Map<Integer,DistLevel> map = new TreeMap<>();
    static void topView2(Node root, int dist, int level){
        if(root == null){
            return;
        }
        if(map.get(dist) == null){
            map.put(dist,new DistLevel(root.data, level));
        }
        else if(map.get(dist).level > level){
            map.put(dist,new DistLevel(root.data, level));
        }
        topView2(root.left,dist-1,level+1);
        topView2(root.right,dist+1,level+1);
    }
    static void topViewPrint(Node root){
        topView2(root,0,0);
        for(Map.Entry<Integer,DistLevel> m : map.entrySet()){
            System.out.print(m.getValue().data + " ");
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        topView(root);
        System.out.println();
        topViewPrint(root);
    }
}
