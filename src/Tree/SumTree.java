package Tree;

public class SumTree {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static int sumTreeConverter(Node root){
        if(root == null){
            return 0;
        }
        int val = root.data;
        root.data = sumTreeConverter(root.left) + sumTreeConverter(root.right);
        return root.data + val;
    }
    static void inOrder(Node root){
        if(root == null){
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
        System.out.println();
        sumTreeConverter(root);
        inOrder(root);
    }
}
