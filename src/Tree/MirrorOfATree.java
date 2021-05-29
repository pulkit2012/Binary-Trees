package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorOfATree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static Node mirror(Node root) {
        if (root == null) {
            return root;
        }
        Node left = mirror(root.left);
        Node right = mirror(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    static void mirror2(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            Node temp2 = temp.left;
            temp.left = temp.right;
            temp.right = temp2;

            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        inOrder(root);
       // mirror(root);
        mirror2(root);
        System.out.println();
        inOrder(root);
    }
}
