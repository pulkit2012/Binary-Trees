package Tree;

public class DistBetweenNodes {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static int d1 = -1;
    static int d2 = -1;
    static int dist = 0;
    //Method 1 O(n)
    static int findLevel(Node root, int k, int level) {
        if (root == null) {
            return -1;
        }
        if (root.data == k) {
            return level;
        }
        int l = findLevel(root.left, k, level + 1);
        return (l != -1) ? l : findLevel(root.right, k, level + 1);
    }

    static Node findLCA2(Node root, int n1, int n2, int level) {
        if (root == null) {
            return null;
        }
        if (root.data == n1) {
            d1 = level;
            return root;
        }
        if (root.data == n2) {
            d2 = level;
            return root;
        }
        Node left_lca = findLCA2(root.left, n1, n2, level + 1);
        Node right_lca = findLCA2(root.right, n1, n2, level + 1);

        if (left_lca != null && right_lca != null) {
            dist = (d1 + d2) - 2 * level;
            return root;
        }
        return (left_lca != null) ? left_lca : right_lca;
    }

    static int distance(Node root, int n1, int n2) {
        d1 = -1;
        d2 = -1;
        dist = 0;
        Node lca = findLCA2(root,n1,n2,1);
        if(d1 != -1 && d2 != -1){
            return dist;
        }
        if(d1 != -1){
            dist = findLevel(lca,n2,0);
            return dist;
        }
        if(d2 != -1){
            dist = findLevel(lca,n1,0);
            return dist;
        }
        return -1;
    }
    //Method 2 O(n)
    static Node findLCA3(Node root,int n1,int n2){
        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }
        Node left_lca = findLCA3(root.left,n1,n2);
        Node right_lca = findLCA3(root.right,n1,n2);
        if(left_lca != null && right_lca != null){
            return root;
        }
        if(left_lca == null && right_lca == null){
            return null;
        }
        return (left_lca != null) ? left_lca : right_lca;
    }
    static int levelFinder(Node root, int a,int level){
        if(root == null) {
            return -1;
        }
        if(root.data == a){
            return level;
        }
        int left = findLevel(root.left,a,level+1);
        if(left == -1){
            return findLevel(root.right,a,level+1);
        }
        return left;
    }
    static int distance2(Node root,int n1,int n2){
        Node lca = findLCA3(root,n1,n2);
        int d1 = findLevel(lca,n1,0);
        int d2 = findLevel(lca,n2,0);
        return d1+d2;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println(distance(root,4,6));
        System.out.println(distance2(root,4,6));
    }
}
