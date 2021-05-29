package Tree;

public class HeightOfTree {

    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
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
        return Math.max(left,right);
    }
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.right.right = new Node(7);
        System.out.println(height(root));
    }
}
