package Tree;

import java.util.Vector;

public class PrintKPath {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }



    static void printer(Vector<Integer> vector, int i) {

        for (int j = i; j < vector.size(); j++) {
            System.out.print(vector.get(j) + " ");
        }
        System.out.println();
    }
    static Vector<Integer> path = new Vector<>();
    static void printKPath(Node root, int k) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        printKPath(root.left, k);
        printKPath(root.right, k);
        int f = 0;
        for (int j = path.size() - 1; j >= 0; j--) {
            f += path.get(j);
            if (f == k) {
                printer(path, j);
            }
        }
        path.remove(path.size() - 1);
    }

    static void printKPathMain(Node root, int k) {
        path = new Vector<Integer>();
        printKPath(root, k);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
        int k = 5;
        printKPathMain(root, k);
    }
}
