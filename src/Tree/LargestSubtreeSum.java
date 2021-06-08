package Tree;

public class LargestSubtreeSum {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class INT {
        int v;

        INT(int a) {
            v = a;
        }
    }
    static int findLargestSubtreeUtil(Node root, INT ans) {
        if (root == null) {
            return 0;
        }
        int currSum = root.data + findLargestSubtreeUtil(root.left, ans) + findLargestSubtreeUtil(root.right, ans);
        ans.v = Math.max(currSum, ans.v);
        return currSum;
    }
    static int findLargestSubtree(Node root){
        if(root == null){
            return 0;
        }
        INT ans = new INT(-9999999);
        findLargestSubtreeUtil(root,ans);
        return ans.v;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);
        System.out.println(findLargestSubtree(root));
    }

}
