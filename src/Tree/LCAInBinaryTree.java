package Tree;

public class LCAInBinaryTree {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Node root;
    static boolean v1 = false;
    static boolean v2 = false;
    static Node findLCA(int n1,int n2){
        v1 = false;
        v2 = false;
        Node lca = findLCA2(root,n1,n2);
        if(v1 && v2){
            return lca;
        }
        return null;
    }
    static Node findLCA2(Node root,int n1,int n2){
        if(root == null){
            return null;
        }
        Node temp = null;
        if(root.data == n1){
            v1 = true;
            temp = root;
        }
        if(root.data == n2){
            v2 = true;
            temp = root;
        }
        Node left_lca = findLCA2(root.left,n1,n2);
        Node right_lca = findLCA2(root.right,n1,n2);
        if(temp != null){
            return temp;
        }
        if(left_lca != null && right_lca != null){
            return root;
        }
        return (left_lca != null) ? left_lca : right_lca;
    }


    public static void main(String[] args) {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node lca = findLCA(4,10);
        if(lca != null){
            System.out.println(lca.data);
        }
        else {
            System.out.println("Error");
        }
    }
}
