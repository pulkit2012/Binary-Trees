package Tree;

public class IsSumTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        return (sum(root.left) + root.data + sum(root.right));
    }

    static boolean isSumTre(Node root) {
        int left, right;
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        left = sum(root.left);
        right = sum(root.right);
        if ((root.data == left + right) && isSumTre(root.left) && isSumTre(root.right)) {
            return true;
        }
        return false;
    }

    // another approach
    static boolean isLeaf(Node root) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        return false;
    }

    static boolean isSumTree2(Node root) {
        int left;
        int right;
        if (root == null || isLeaf(root)) {
            return true;
        }
        if (isSumTree2(root.left) && isSumTree2(root.right)) {
            if (root.left == null) {
                left = 0;
            } else if (isLeaf(root.left)) {
                left = root.left.data;
            } else {
                left = 2 * root.left.data;
            }
            if (root.right == null) {
                right = 0;
            } else if (isLeaf(root.right)) {
                right = root.right.data;
            } else {
                right = 2 * root.right.data;
            }
            if (root.data == left + right) {
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(15);
        root.right = new Node(11);
        root.left.left = new Node(6);
        root.left.right = new Node(9);
        root.right.right = new Node(6);
        root.right.left = new Node(4);
        System.out.println(isSumTre(root));
        System.out.println(isSumTree2(root));
    }
}
