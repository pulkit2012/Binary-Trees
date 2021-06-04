package Tree;

public class SumOfLongestPath {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static int maxSum = 0;
    static int maxLen = 0;
    static void sumOfLongRootToLeafPath(Node root,int sum,int len){
        if(root == null){
            if(maxLen < len){
                maxLen = len;
                maxSum = sum;
            }
            else if(maxLen == len && maxSum < sum){
                maxSum = sum;
            }
            return;
        }
        sumOfLongRootToLeafPath(root.left,sum+ root.data,len+1);
        sumOfLongRootToLeafPath(root.right,sum+root.data,len+1);
    }
    static int sumOfRootToLeaf(Node root){
        if(root == null){
            return 0;
        }
        maxSum = Integer.MIN_VALUE;
        maxLen = 0;
        sumOfLongRootToLeafPath(root,0,0);
        return maxSum;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(sumOfRootToLeaf(root));
    }
}
