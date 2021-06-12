package Tree;

import java.util.HashMap;

public class Practise {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void checker(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        checker(root.left);
        checker(root.right);
    }
    static void printer(Node root){
        if(root == null){
            return;
        }
        if(root.left != null){
            System.out.print(root.data + " ");
            printer(root.left);
        }
       else if(root.right != null){
            System.out.print(root.data + " ");
            printer(root.right);
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        //checker(root);
        printer(root);
        HashMap<Integer,Integer>map;
        //map.s
    }
}

