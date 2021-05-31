package Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                System.out.println(data + " Inserted to the left of " + root.data);
                root.left = new Node(data);
            }
        } else if (data > root.data) {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                System.out.println(data + " inserted to the right of " + root.data);
                root.right = new Node(data);
            }
        }
    }

    static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    static void inOrderWithoutRecursion(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }

    }

    static void morrisInorder(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }
            }
        }
    }

    static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void preOrderWithoutRecursion(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.peek();
            System.out.print(node.data + " ");
            stack.pop();

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    static void preOrderTraversalWithoutStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;
        while (curr != null || !stack.isEmpty()) {

            while (curr != null) {
                System.out.print(curr.data + " ");
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                curr = curr.left;
            }

            if (!stack.isEmpty()) {
                curr = stack.pop();
            }
        }
    }

    static void morrisPreorder(Node root) {
        Node current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.data + " ");
                current = current.right;
            } else {
                Node pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    System.out.print(current.data + " ");
                    current = current.left;
                } else {
                    pre.right = null;
                    current = current.right;
                }
            }
        }
    }

    static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    static void postOrderTwoStacks(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if (root == null) {
            return;
        } else {
            stack.push(root);
            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                stack2.push(temp);
                if (temp.left != null) {
                    stack.push(temp.left);
                }
                if (temp.right != null) {
                    stack.push(temp.right);
                }
            }
            while (!stack2.isEmpty()) {
                Node temp = stack2.pop();
                System.out.print(temp.data + " ");
            }
        }
    }

    static void postOrderOneStack(Node root) {
        Stack<Node> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) {
                return;
            }
            root = stack.pop();
            if (!stack.isEmpty() && stack.peek() == root) {
                root = root.right;
            } else {
                System.out.print(root.data + " ");
                root = null;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);


        //inorder Traversals-----------------
        // inorderTraversal(root);
        //inOrderWithoutRecursion(root);
        //System.out.println();
        //morrisInorder(root);


        //Pre Order Traversals-----------------
        //preOrderTraversal(root);
        //System.out.println();
        // morrisPreorder(root);
        //preOrderWithoutRecursion(root);
        //System.out.println();
        //preOrderTraversalWithoutStack(root);

        //post Order Traversals----------------
        //postOrderTraversal(root);
        //System.out.println();
        // postOrderTwoStacks(root);
        // System.out.println();
        //postOrderOneStack(root);
    }
}
