package Tree;

import java.util.HashSet;

public class SubtreeOfTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    //approach time complexity:- O(mn)m = n = number of nodes in trees
    static boolean areIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.data == root2.data && areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right));
    }

    static boolean isSubTree(Node root1, Node root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (areIdentical(root1, root2)) {
            return true;
        }
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }

    static char Marker = '$';

    static String dupSubUtil(Node root, HashSet<String> subtrees) {
        String s = "";
        if (root == null) {
            return s + Marker;
        }
        String left = dupSubUtil(root.left, subtrees);
        if (left.equals(s)) {
            return s;
        }
        String right = dupSubUtil(root.right, subtrees);
        if (right.equals(s)) {
            return s;
        }
        s = s + root.data + left + right;
        if(s.length() > 3 && subtrees.contains(s)){
            return "";
        }
        subtrees.add(s);
        return s;
    }
    static String dubSub(Node root){
        HashSet<String> subtrees = new HashSet<>();
        return dupSubUtil(root,subtrees);
    }

    public static void main(String[] args) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
        root.right.right.right = new Node('E');
        root.right.right.left= new Node('D');
//        System.out.println(isSubTree(r));
        String str = dubSub(root);
        System.out.println(str.equals("") ? "Yes" : "No");
    }
}
