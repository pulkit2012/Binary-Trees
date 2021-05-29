package Tree;

//Algo -------------->
//diameter is the no. nodes between the two deepest leaves
//it is calculated using the height of both the subtrees
public class DiameterOfTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }


   static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDia = diameter(root.left);
        int rightDia = diameter(root.right);

        return Math.max((leftHeight + rightHeight + 1),Math.max(leftDia,rightDia));
   }

   static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.max(left+1,right+1);
   }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(diameter(root));

    }
}
