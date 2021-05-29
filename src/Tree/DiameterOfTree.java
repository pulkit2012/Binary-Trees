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
static class Min{
        int mini = Integer.MIN_VALUE;
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
//O(n) approach height2 and dia2
    static int height2(Node root,Min min){
        if(root == null){
            return 0;
        }
        int lheight = height2(root.left,min);
        int rheight = height2(root.right,min);

        min.mini = Math.max(min.mini,(1+lheight+rheight));
        return Math.max(1+lheight,1+rheight);
    }
    static int diameter2(Node root){
        if(root == null){
            return 0;
        }
        Min min = new Min();
        int ans = height2(root,min);
        return min.mini;
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(diameter(root));
        System.out.println(diameter2(root));

    }
}
