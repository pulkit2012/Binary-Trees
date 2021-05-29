package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrder {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static void insert(Node root,int data){
        if(data < root.data){
            if(root.left != null){
                insert(root.left,data);
            }
            else {
                System.out.println(data + " inserted at left of " + root.data);
                root.left = new Node(data);
            }
        }
        else if(data > root.data){
           if(root.right != null){
               insert(root.right,data);
           }
           else {
               System.out.println(data + " inserted at right of " + root.data);
               root.right = new Node(data);
           }
        }
    }
    static void levelOrderTraversal(Node root){
        int h = height(root);
        for (int i = 1; i <= h; i++) {
            printLevelOrder(root,i);
        }
    }
    static void printLevelOrder(Node root,int level){
        if(root == null){
            return;
        }
        if(level == 1){
            System.out.print(root.data + " ");
        }
        else if(level > 1){
            printLevelOrder(root.left,level-1);
            printLevelOrder(root.right,level-1);
        }
    }
    static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if (left > right) {
            return (left + 1);
        }
        else{
            return (right + 1);
        }
    }
    static void printLevelOrderMethod2(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if(tempNode.left != null){
                queue.add(tempNode.left);
            }
            if(tempNode.right != null){
                queue.add(tempNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter root");
        int a = in.nextInt();
        in.nextLine();
        Node root = new Node(a);
        System.out.println("Enter values , type exit to exit");

        while (true) {
            String b = in.nextLine().trim();
            if (b.equals("exit")) {
                break;
            }
            insert(root, Integer.parseInt(b));
        }
        //System.out.println("height = " + height(root) + " height2 " + height2(root));
        levelOrderTraversal(root);
        System.out.println();
        printLevelOrderMethod2(root);
    }

}
