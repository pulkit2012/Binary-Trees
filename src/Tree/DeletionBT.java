package Tree;

//Algo:-
//Find the Rightmost and deepest element in the tree
//then find the element to be removed
//replace this element with the rightmost element
//delete the rightmost element

import java.util.LinkedList;
import java.util.Queue;

public class DeletionBT {
    static class Node{
        int data;
        Node right,left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    static void deleteDeepest(Node root, Node node){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp = null;
        while (!queue.isEmpty()){
            temp = queue.poll();
            if(temp == node){
                temp = null;
                return;
            }
          if(temp.right != null){
              if(temp.right == node){
                  temp.right = null;
                  return;
              }
              else {
                  queue.add(temp.right);
              }
          }
          if(temp.left != null){
              if(temp.left == node){
                  temp.left = null;
                  return;
              }
              else {
                  queue.add(temp.left);
              }
          }
        }
    }
    static void delete(Node root, int value){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            if(root.data == value) {
                root = null;
                return;
            }
            else {
                return;
            }
        }
        Queue<Node> queue1 = new LinkedList<>();
        queue1.add(root);
        Node temp = null;
        Node node = null;
        while (!queue1.isEmpty()){
            temp = queue1.poll();
            if(temp.data == value){
                node = temp;
            }
            if(temp.left != null){
                queue1.add(temp.left);
            }
            if(temp.right != null){
                queue1.add(temp.right);
            }

        }
        if(node != null){
            int x = temp.data;
            deleteDeepest(root,temp);
            node.data = x;
        }

    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.left.right = new Node(12);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);

        inorder(root);
        int value = 11;
        delete(root,value);
        System.out.println();
        inorder(root);
    }

}
