package Tree;

public class TreeIsoMorphism {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static boolean isIsoMorphic(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.data != root2.data) {
            return false;
        }
        return (isIsoMorphic(root1.left, root2.left) && isIsoMorphic(root1.right, root2.right))
                || (isIsoMorphic(root1.left, root2.right) && isIsoMorphic(root1.right, root2.left));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(4);
        root1.right.right = new Node(5);
        root1.left.right = new Node(6);
        root1.right.right.left = new Node(8);
//        root1.right.right.right = new Node(7);
        System.out.println(isIsoMorphic(root1,root));
    }
}
