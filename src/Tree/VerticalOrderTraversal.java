package Tree;

import com.sun.source.tree.Tree;

import javax.swing.*;
import java.util.*;

public class VerticalOrderTraversal {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static class Val{
        int max,min;
    }
    static Val values = new Val();
    //O(n^2) approach
    static void findMinMax(Node root,Val min,Val max,int hd){
        if(root == null){
            return;
        }
        if(hd < min.min){
            min.min = hd;
        }
        else if(hd > max.max){
            max.max = hd;
        }
        findMinMax(root.left,min,max,hd-1);
        findMinMax(root.right,min,max,hd+1);
    }
    static void printLine(Node root, int line_no,int hd){
        if(root == null){
            return;
        }
        if(hd == line_no){
            System.out.print(root.data + " ");
        }
        printLine(root.left,line_no,hd-1);
        printLine(root.right,line_no,hd+1);
    }
    static void verticalOrder(Node root){
        findMinMax(root,values,values,0);
        for (int i = values.min; i <= values.max; i++) {
            printLine(root,i,0);
            System.out.println();
        }
    }
    //O(n) using map
    static void getVerticalOrder(Node root,int hd, TreeMap<Integer,Vector<Integer>> m){
        if(root == null){
            return;
        }
        Vector<Integer> get = m.get(hd);
        if(get == null){
            get = new Vector<>();
            get.add(root.data);
        }
        else {
            get.add(root.data);
        }
        m.put(hd,get);
        getVerticalOrder(root.left,hd-1,m);
        getVerticalOrder(root.right,hd+1,m);

    }
    static void printVerticalOrder(Node root){
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root,hd,m);
        for(Map.Entry<Integer,Vector<Integer>> entry : m.entrySet()){
            System.out.println(entry.getValue());
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
    //best of all
    static void verticalOrderUsingLevelOrder(Node root){
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        int pos = 0;
        Queue<posData> queue = new LinkedList<>();
        queue.add(new posData(0,root));
        while (!queue.isEmpty()){
            posData temp = queue.poll();
            pos = temp.pos;
            Node tempNode = temp.node;

            if(map.containsKey(pos)){
                map.get(pos).add(tempNode.data);
            }
            else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(tempNode.data);
                map.put(pos,al);
            }
            if(tempNode.left != null){
                queue.add(new posData(pos-1,tempNode.left));
            }
            if(tempNode.right != null){
                queue.add(new posData(pos+1,tempNode.right));
            }
        }
        for(Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()){
            ArrayList<Integer> al = entry.getValue();
            for(int i : al){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        verticalOrder(root);
        System.out.println();
        printVerticalOrder(root);
        System.out.println();
        verticalOrderUsingLevelOrder(root);
    }
}
