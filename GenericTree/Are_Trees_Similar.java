package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Are_Trees_Similar {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) {
     *     Time Complexity will be O(N) as we have traversed every Node of both the trees if they are in same shape.
     * }
     *
     * Space Complexity -> O(1) and O(logn) (Recursion) {
     *      The space complexity is O(1) as we have not used any extra data structure.
     *      As usual if we consider the recursion space then the space complexity will be O(logn)
     *      as the max height of the stack at any point will be the same as the height of the tree i.e. O(logn).
     * }
     * @param tree1
     * @param tree2
     * @return
     */
    public static boolean areSimilar(Node tree1, Node tree2){
        if (tree1.children.size()!=tree2.children.size())
            return false;
        for (int i=0 ; i<tree1.children.size() ; i++){
            Node tree1Node = tree1.children.get(i);
            Node tree2Node = tree2.children.get(i);
            if (!areSimilar(tree1Node, tree2Node)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i : array){
            if (i==-1){
                stack.pop();
            } else {
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
        System.out.println(areSimilar(root, root));
    }
}
