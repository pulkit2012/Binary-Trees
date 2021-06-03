package Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TreeFromInorderAndPreOrder {
    static class Node {
        char data;
        Node left, right;

        public Node(char data) {
            this.data = data;
            left = right = null;
        }
    }

    //Recursive approach Time:- O(n^2)
    static int preIndex = 0;

    static Node buildTree(char[] preOrder, char[] inOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(preOrder[preIndex++]);
        if (start == end) {
            return node;
        }
        int index = search(inOrder, start, end, node.data);
        node.left = buildTree(preOrder, inOrder, start, index - 1);
        node.right = buildTree(preOrder, inOrder, index + 1, end);
        return node;
    }

    static int search(char[] inOrder, int start, int end, char val) {
        int i;
        for (i = start; i <= end; i++) {
            if (inOrder[i] == val) {
                return i;
            }
        }
        return i;
    }

    static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }


    //Another Recursive approach using Map Time:- O(n)
    static HashMap<Character, Integer> map = new HashMap<>();
    static int preIndex2 = 0;

    static Node buildTree1(char[] inOrder, char[] preOrder, int start, int end) {
        if (start > end) {
            return null;
        }
        Node node = new Node(preOrder[preIndex2++]);
        if (start == end) {
            return node;
        }
        int index = map.get(node.data);
        node.left = buildTree1(inOrder, preOrder, start, index - 1);
        node.right = buildTree1(inOrder, preOrder, index + 1, end);
        return node;
    }

    static Node mapCreatorMain(char[] inOrder, char[] preOrder, int len) {
        for (int i = 0; i < len; i++) {
            map.put(inOrder[i], i);
        }
        return buildTree1(inOrder, preOrder, 0, len - 1);
    }

    //Iterative Approach
    static HashSet<Node> set = new HashSet<>();
    static Stack<Node> stack = new Stack<>();

    // Function to build tree using given traversal
    static Node buildTree2(char[] preorder, char[] inorder) {
        Node root = null;
        for (int pre = 0, in = 0; pre < preorder.length; ) {

            Node node = null;
            do {
                node = new Node(preorder[pre]);
                if (root == null) {
                    root = node;
                }
                if (!stack.isEmpty()) {
                    if (set.contains(stack.peek())) {
                        set.remove(stack.peek());
                        stack.pop().right = node;
                    } else {
                        stack.peek().left = node;
                    }
                }
                stack.push(node);
            } while (preorder[pre++] != inorder[in] && pre < preorder.length);

            node = null;
            while (!stack.isEmpty() && in < inorder.length &&
                    stack.peek().data == inorder[in]) {
                node = stack.pop();
                in++;
            }

            if (node != null) {
                set.add(node);
                stack.push(node);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int length = in.length;
//        Node root = buildTree(pre, in, 0, length - 1);
//        printInOrder(root);
//        System.out.println();
//        Node root1 = mapCreatorMain(in, pre, length);
//        printInOrder(root1);
//        System.out.println();
        Node root2 = buildTree2(pre, in);
        printInOrder(root2);
    }
}
