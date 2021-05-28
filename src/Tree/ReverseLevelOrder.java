package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrder {
    static class Node{
        int data;
        Node right,left;

        public Node(int data) {
            this.data = data;
            right = left = null;
        }
    }

    static int height(Node root){
        int left = 0;
        int right = 0;
        if(root != null){
            if(root.left != null){
                left = 1 + height(root.left);
            }
            if(root.right != null){
                right = 1 + height(root.right);
            }
        }
       return Math.max(right,left);
    }
    static void reverseLevelOrder(Node root){
        int h = height(root);
        for (int i = h+1; i >= 1; i--) {
            printReverseLevel(root,i);
        }
    }
    static void printReverseLevel(Node root,int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data + " ");
        }
        else if(level > 1){
            printReverseLevel(root.left,level-1);
            printReverseLevel(root.right,level-1);
        }

    }
    static void printReverseLevelMeth2(Node root){
        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            stack.push(temp);
            if(temp.right != null){
                queue.add(temp.right);
            }
            if(temp.left != null){
                queue.add(temp.left);
            }
        }
        while (!stack.isEmpty()){
            Node node = stack.peek();
            System.out.print(node.data + " ");
            stack.pop();
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        reverseLevelOrder(root);
        System.out.println();
        printReverseLevelMeth2(root);
    }
}
class test{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);

    }
}