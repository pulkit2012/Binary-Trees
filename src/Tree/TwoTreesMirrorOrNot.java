package Tree;

public class TwoTreesMirrorOrNot {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static boolean areMirror(Node root1,Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null){
            return false;
        }
        return (root1.data == root2.data) && areMirror(root1.left,root2.right) && areMirror(root1.right,root2.left);
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(1);
        a.left = new Node(2);
        a.right = new Node(3);
        a.left.left = new Node(4);
        a.left.right = new Node(5);

        b.left = new Node(3);
        b.right = new Node(2);
        b.right.left = new Node(5);
        b.right.right = new Node(4);
        System.out.println(areMirror(a,b) ? "Yes" : "No");
    }
}
