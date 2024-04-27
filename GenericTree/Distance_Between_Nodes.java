package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Distance_Between_Nodes {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToRootPath(Node root, int data){
        if (root.data==data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }
        for (Node child : root.children){
            ArrayList<Integer> pathToChild = nodeToRootPath(child, data);
            if (pathToChild.size()>0){
                pathToChild.add(root.data);
                return pathToChild;
            }
        }
        return new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) {
     *     Finding the node in the entire tree to get the node to the root path takes O(n).
     *     Then, just traversing the node-to-root path (arrays) takes O(d) where d = depth of the node.
     *     In the worst case, d can be equal to n, hence total time complexity will be O(n) only.
     * }
     *
     * Space Complexity -> O(N) {
     *     We are storing the Node the Root path so total auxiliary size is O(N).
     * }
     * @param root
     * @param p1
     * @param p2
     * @return
     */
    public static int distanceBetweenNodes(Node root, int p1, int p2){
        ArrayList<Integer> list1 = nodeToRootPath(root, p1);
        ArrayList<Integer> list2 = nodeToRootPath(root, p2);
        int i = list1.size()-1;
        int j = list2.size()-1;
        while(i>=0 && j>=0 && list1.get(i)==list2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i+j;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i : array){
            if (i==-1)
                stack.pop();
            else {
                Node temp = new Node();
                temp.data = i;
                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
        System.out.println(distanceBetweenNodes(root, 70, 110));
    }
}
