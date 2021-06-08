package Tree;

import java.util.HashMap;

public class MaximizingSumOfNodes {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //Method 1 O(n)
    static int sumOfGrandChildren(Node root, HashMap<Node,Integer> map){
        int sum = 0;
        if(root.left != null){
            sum += getMaxSumUtil(root.left.left,map) + getMaxSumUtil(root.left.right,map);
        }
        if(root.right != null){
            sum += getMaxSumUtil(root.right.right,map) + getMaxSumUtil(root.right.left,map);
        }
        return sum;
    }
    static int getMaxSumUtil(Node root, HashMap<Node,Integer> map){
        if(root == null){
            return 0;
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        int incl = root.data + sumOfGrandChildren(root,map);
        int excl = getMaxSumUtil(root.left,map) + getMaxSumUtil(root.right,map);
        map.put(root,Math.max(incl,excl));
        return map.get(root);
    }
    static int getMaxSum(Node root){
        if(root == null){
            return 0;
        }
        HashMap<Node,Integer> map = new HashMap<>();
        return getMaxSumUtil(root,map);
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left = new Node(1);
        System.out.print(getMaxSum(root));
    }
}
