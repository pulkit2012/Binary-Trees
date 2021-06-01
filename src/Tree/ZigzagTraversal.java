package Tree;

import java.util.Stack;

public class ZigzagTraversal {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //iterative space:- O(n) time:- O(n)
    static void zigzagTraversal(Node root){
        if(root == null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node temp = stack1.pop();
                System.out.print(temp.data + " ");

                if (temp.right != null) {
                    stack2.push(temp.right);
                }
                if (temp.left != null) {
                    stack2.push(temp.left);
                }
            }
            while (!stack2.isEmpty()) {
                Node temp2 = stack2.pop();
                System.out.print(temp2.data + " ");
                if(temp2.left != null){
                    stack1.push(temp2.left);
                }
                if(temp2.right != null){
                    stack1.push(temp2.right);
                }
            }
        }
    }
    //recursive approach time:- O(n^2)
    static void zigzagTraversal2(Node root){
        int h = height(root);
        boolean bool = false;
        for (int i = 1; i <= h; i++) {
            zigzagTraversal2Util(root,bool,i);
            bool = !bool;
        }
    }
    static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(1+left,1+right);
    }
    static void zigzagTraversal2Util(Node root,boolean bool,int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data + " ");
        }
        else if(level > 1){
            if(bool){
                zigzagTraversal2Util(root.left,bool,level-1);
                zigzagTraversal2Util(root.right,bool,level-1);
            }
            else{
                zigzagTraversal2Util(root.right,bool,level-1);
                zigzagTraversal2Util(root.left,bool,level-1);
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        zigzagTraversal(root);
        System.out.println();
        zigzagTraversal2(root);
    }
}
