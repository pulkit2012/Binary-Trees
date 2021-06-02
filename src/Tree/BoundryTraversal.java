package Tree;

import java.util.*;

public class BoundryTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    //recursive approach
    static void topToLeftPrinter(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.print(root.data + " ");
            topToLeftPrinter(root.left);
        } else if (root.right != null) {
            System.out.print(root.data + " ");
            topToLeftPrinter(root.right);
        }
    }

    static void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        printLeaves(root.right);
    }

    static void bottomToTopRight(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            bottomToTopRight(root.right);
            System.out.print(root.data + " ");
        }
        if (root.left != null) {
            bottomToTopRight(root.left);
            System.out.print(root.data + " ");
        }
    }

    static void BoundaryTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        topToLeftPrinter(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        bottomToTopRight(root.right);
    }

    //iterative approach for complete binary tree
    static void BoundaryTraversal2Complete(Node root) {
        if (root == null) {
            return;
        }
        Vector<Integer> list = new Vector<>();
        Node l = root.left;
        while (l.left != null) {
            list.add(root.data);
            l = l.left;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.left == null && temp.right == null) {
                list.add(temp.data);
            }
            if (temp.left != null) {
                q.add(temp.left);
            }
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
        Node r = root.right;
        Vector<Integer> right_l = new Vector<>();
        while (r.right != null) {
            right_l.add(r.data);
            r = r.right;
        }
        Collections.reverse(right_l);
        list.addAll(right_l);
        System.out.println(list);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        BoundaryTraversal(root);
        System.out.println();
       /// BoundaryTraversal2Complete(root);

    }
}
