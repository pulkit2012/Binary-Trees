package Tree;

import java.util.*;

public class DiognalTraversal {
    static class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //recursive approach time:- O(N logN) space:- O(N)
    static TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
    static void diagonalPrintUtil(Node root,int d){
        if(root == null){
            return;
        }
        if(map.get(d) == null){
            Vector<Integer> list = new Vector<>();
            list.add(root.data);
            map.put(d,list);
        }
        else{
            map.get(d).add(root.data);
        }
        diagonalPrintUtil(root.left,d+1);
        diagonalPrintUtil(root.right,d);
    }
    static void diagonalTraversal(Node root){
        diagonalPrintUtil(root,0);
        for(Map.Entry<Integer,Vector<Integer>> m : map.entrySet()){
            for (int c: m.getValue()){
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
    //Iterative Approach
    static void diagonalTraversal2(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Node curr = root;
        while (curr != null || !q.isEmpty()){
            if(curr != null){
                System.out.print(curr.data + " ");
                if(curr.left != null){
                    q.add(curr.left);
                }
                curr = curr.right;
            }
            else {
                curr = q.poll();
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        diagonalTraversal(root);
        System.out.println();
        diagonalTraversal2(root);
    }
}
