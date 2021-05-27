package Tree;


import java.util.Scanner;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                System.out.println(data + " Inserted to the left of " + root.data);
                root.left = new Node(data);
            }
        } else if (data > root.data) {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                System.out.println(data + " inserted to the right of " + root.data);
                root.right = new Node(data);
            }
        }
    }

    static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter root");
        int a = in.nextInt();
        in.nextLine();
        Node root = new Node(a);
        System.out.println("Enter values , type exit to exit");

        while (true) {
            String b = in.nextLine().trim();
            if (b.equals("exit")) {
                break;
            }
            insert(root, Integer.parseInt(b));
        }
        inorderTraversal(root);
        postOrderTraversal(root);
        preOrderTraversal(root);
    }
}
