package Tree;

public class KthAncestor {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Node temp;
    static int k;
    static Node kthAncestor(Node root,int data){
        if(root == null){
            return null;
        }
        if(root.data == data || (temp = kthAncestor(root.left, data)) !=null || (temp = kthAncestor(root.right,data)) != null){
            if(k > 0){
                k--;
            }
            else if(k == 0){
                System.out.print("Kth ancestor is " + root.data);
                return null;
            }
            return root;
        }
        return null;
    }
//    static Node newNode(int data){
//        Node temp = new Node(data);
//        temp.left = temp.right = null;
//        return temp;
//    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        k = 2;
        int node = 5;
        Node node1 = kthAncestor(root,node);
        if(node1 != null){
            System.out.println("-1");
        }
    }
}
