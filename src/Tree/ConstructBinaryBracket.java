package Tree;

import java.util.Stack;

public class ConstructBinaryBracket {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static int findIndex(String str,int start,int end){
        if(start > end){
            return -1;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            if(str.charAt(i) == '('){
                stack.push('(');
            }
            else if(str.charAt(i) == ')'){
                if(stack.peek() == '('){
                    stack.pop();
                    if(stack.isEmpty()){
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    static Node treeCreator(String str,int start,int end){
        if(start > end){
            return null;
        }
        Node root = new Node(str.charAt(start) - '0');
        int index = -1;
        if(start+1 <= end && str.charAt(start+1) == '('){
           index = findIndex(str,start+1,end);
        }
        if(index != -1){
            root.left = treeCreator(str,start+2,index-1);
            root.right = treeCreator(str,index+2,end-1);
        }
        return root;
    }
    public static void main(String[] args) {
        String str = "4(2(3)(1))(6(5))";
        Node root = treeCreator(str,0,str.length()-1);
        preOrder(root);
    }
}
