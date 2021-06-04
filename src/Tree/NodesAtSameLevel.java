package Tree;

import java.security.cert.PolicyQualifierInfo;
import java.util.LinkedList;
import java.util.Queue;

public class NodesAtSameLevel {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    //recursive O(n)
    static int level1 = 0;
    static boolean areAtSameLevel(Node root, int level){
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            if(level1 == 0){
                level1 = level;
                return true;
            }
            return level == level1;
        }
        return areAtSameLevel(root.left,level+1) && areAtSameLevel(root.right,level+1);
    }
    static boolean check(Node root){
        int level = 0;
        return areAtSameLevel(root,level);
    }
    //Iterative approach
    static boolean areAtSameLevel2(Node root){
        int level = 0;
        if(root == null){
            return true;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int result = Integer.MAX_VALUE;
        while (!q.isEmpty()){
            int size = q.size();;
            level++;
            while (size > 0){
                Node temp = q.remove();
                if(temp.left != null){
                    q.add(temp.left);
                    if(temp.left.left == null && temp.left.right == null){
                        if(result == Integer.MAX_VALUE){
                            result = level;
                        }
                        else if(result != level){
                            return false;
                        }
                    }
                }
                if(temp.right != null){
                    q.add(temp.right);
                    if(temp.right.left == null && temp.right.right == null){
                        if(result == Integer.MAX_VALUE){
                            result = level;
                        }
                        else if(result != level){
                            return false;
                        }
                    }
                }
                size--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.right = new Node(5);
        System.out.println(check(root));
        System.out.println(areAtSameLevel2(root));
    }
}
