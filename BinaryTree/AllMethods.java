package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class AllMethods {

    static ArrayList<Integer> list;
    static ArrayList<Node> nodeList;

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair {
        int state;
        Node node;

        public Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    /**
     * Time Complexity -> O(N) Tree Traversal is involved which is required
     * Space Complexity -> O(N) Space used by Stack
     */
    public static Node binaryTree(Integer[] array) {
        Node root = new Node(array[0]);
        Pair rootPair = new Pair(1, root);
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);
        int idx = 0;
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                idx++;
                if (array[idx] != null) {
                    Node leftNode = new Node(array[idx]);
                    Pair leftPair = new Pair(1, leftNode);
                    top.node.left = leftNode;
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (array[idx] != null) {
                    Node rightNode = new Node(array[idx]);
                    Pair leftPair = new Pair(1, rightNode);
                    top.node.right = rightNode;
                    stack.push(leftPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }
        return root;
    }

    /**
     * Time Complexity -> O(N)
     * Space Complexity -> O(N) Recursion Stack
     */
    public static void display(Node root) {
        String str = "";
        if (root == null) {
            return;
        }
        str += root.left == null ? "." : root.left.data;
        str += " <- " + root.data + " -> ";
        str += root.right == null ? "." : root.right.data;
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int size(Node root) {
        if (root == null)
            return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return leftSize + rightSize + 1;
    }

    public static int sum(Node root) {
        if (root == null)
            return 0;
        int leftSum = size(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int max(Node root) {
        if (root == null)
            return Integer.MIN_VALUE;
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        int max = Math.max(root.data, Math.max(leftMax, rightMax));
        return max;
    }

    public static int height(Node root) {
        if (root == null)
            return -1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }

    public static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root) {
        if (root == null)
            return;
        preOrder(root.left);
        System.out.print(root.data + " ");
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /**
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(N) <br/>
     */
    public static void levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                root = queue.remove();
                System.out.print(root.data + " ");
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
            System.out.println();
        }
    }

    public static void iterativeTraversal(Node root){
        String pre = "";
        String in = "";
        String post = "";
        Stack<Pair> stack = new Stack<>();
        Pair rootPair = new Pair(1, root);
        stack.push(rootPair);
        while(stack.size()>0){
            Pair top = stack.peek();
            if (top.state==1){
                pre+= top.node.data + " ";
                top.state++;
                if (top.node.left!=null){
                    Pair leftPair = new Pair(1, top.node.left);
                    stack.push(leftPair);
                }
            } else if (top.state == 2) {
                in+= top.node.data + " ";
                top.state++;
                if (top.node.right != null) {
                    Pair rightPair = new Pair(1, top.node.right);
                    stack.push(rightPair);
                }
            } else {
                post+= top.node.data + " ";
                stack.pop();
            }
        }
        System.out.println("Pre-Order : " + pre);
        System.out.println("In-Order : " + in);
        System.out.println("Post-Order : " + post);
    }

    public static boolean find(Node root, int data){
        if (root==null)
            return false;

        if (root.data==data) {
            list.add(root.data);
            nodeList.add(root);
            return true;
        }

        boolean filn = find(root.left, data);
        if (filn) {
            list.add(root.data);
            nodeList.add(root);
            return true;
        }

        boolean firn = find(root.right, data);
        if (firn) {
            list.add(root.data);
            nodeList.add(root);
            return true;
        }

        return false;
    }

    public static void kLevelDown(Node root, int k){
        if (root==null || k<0){
            return;
        }

        if (k==0){
            System.out.println(root.data);
            return;
        }

        kLevelDown(root.left, k-1);
        kLevelDown(root.right, k-1);
    }

    public static void kLevelDown(Node root, int k, Node blocker){
        if (root==null || k<0 || blocker==null){
            return;
        }

        if (k==0){
            System.out.println(root.data);
            return;
        }

        kLevelDown(root.left, k-1, blocker);
        kLevelDown(root.right, k-1, blocker);
    }

    public static void printKNodesAway(Node root, int data, int k){
        nodeList = new ArrayList<>();
        find(root, data);
        for (int i=0 ; i<nodeList.size() ; i++){
            kLevelDown(nodeList.get(i), k-i, i==0 ? null : nodeList.get(i-1));
        }
    }

    public static Node transformToLeftClonedTree(Node root){
        if (root==null)
            return null;
        Node lnn = transformToLeftClonedTree(root.left);
        Node rnn = transformToLeftClonedTree(root.right);
        Node newNode = new Node(root.data);
        newNode.left = lnn;
        root.right = rnn;
        return root;
    }

    public static Node transformBackToLeftClonedTree(Node root){
        if (root==null)
            return null;
        root.left = transformToLeftClonedTree(root.left.left);
        root.right = transformToLeftClonedTree(root.right);
        return root;
    }

    public static void printSingleChildNodes(Node root, Node parent){
        if (root==null)
            return;
        if (parent!=null && parent.left!=null && parent.right==null){
            System.out.println(root.data);
        }
        if (parent!=null && parent.left==null && parent.right!=null){
            System.out.println(root.data);
        }
        printSingleChildNodes(root.left, root);
        printSingleChildNodes(root.right, root);
    }

    public static Node removeLeafs(Node root){
        if (root==null)
            return null;
        if (root.left==null && root.right==null)
            return null;
        Node lnt = removeLeafs(root.left);
        Node rnt = removeLeafs(root.right);
        root.left = lnt;
        root.right = rnt;
        return root;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = binaryTree(array);
        Node node = removeLeafs(root);
        display(node);
    }
}
