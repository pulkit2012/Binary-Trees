package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightView {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //iterative approach
    static void rightView(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                Node temp = q.poll();
                if (temp != null) {
                    if (i == n) {
                        System.out.print(temp.data + " ");
                    }
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }
                }
            }
        }
    }
    //recursive approach
    static int max_level = 0;
    static void rightView2Util(Node root,int level){
        if(root == null){
            return;
        }
        if(max_level < level){
            System.out.print(root.data + " ");
            max_level = level;
        }
        rightView2Util(root.right,level+1);
        rightView2Util(root.left,level+1);
    }
    static void rightView2(Node root) {
        rightView2Util(root, 1);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        rightView(root);
        System.out.println();
        rightView2(root);
    }
}
