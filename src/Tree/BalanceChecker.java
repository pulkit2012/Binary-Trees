package Tree;

public class BalanceChecker {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //O(n^2 approach)
    static boolean balanceChecker(Node root){
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        if(Math.abs(lh - rh) <= 1 && balanceChecker(root.left) && balanceChecker(root.right)){
            return true;
        }
        return false;
    }
    static int height(Node root){
        if (root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(1+left,1+right);
    }
    //O(n) approach
    static class Height{
        int height = 0;
    }
    static boolean isBalanced(Node root,Height height){
        if(root == null){
            height.height = 0;
            return true;
        }
        Height lheight = new Height();
        Height rheight = new Height();
        boolean l = isBalanced(root.left,lheight);
        boolean r = isBalanced(root.right,rheight);
        int lh = lheight.height;
        int rh = rheight.height;

        height.height = (Math.max(lh, rh)) + 1;

        if(Math.abs(lh-rh) >= 2){
            return false;
        }
        else {
            return l && r;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(balanceChecker(root) ? "tree is balanced" : "tree is not balanced");
        Height height = new Height();
        System.out.println(isBalanced(root,height) ? "tree is balanced" : "tree is not balanced");

    }
}
