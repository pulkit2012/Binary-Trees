package Tree;

public class BTToDLL {
    static class Node{
        int data;
        Node left,right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
    static Node head;
    static Node prev;
    static void BinaryTreeToDoublyLinkedList(Node root){
        if(root == null){
            return;
        }
        BinaryTreeToDoublyLinkedList(root.left);
        if(prev == null){
            head = root;
        }
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        BinaryTreeToDoublyLinkedList(root.right);
    }
    static void printDoublyLL(Node root){
        while (root != null){
            System.out.print(root.data + " ");
            root = root.right;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        BinaryTreeToDoublyLinkedList(root);
        printDoublyLL(head);
    }
}
