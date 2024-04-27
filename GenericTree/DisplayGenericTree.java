package GenericTree;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.ArrayList;
import java.util.Stack;

public class DisplayGenericTree {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) {
     *     We are traversing the entire tree once, i.e. we are making a recursive call
     *     for display of each node, hence the total time complexity is
     *     O(n) where n = number of nodes in the generic tree.
     * }
     *
     * Space Complexity -> O(1) (Auxiliary Space) and O(N) (Recursion Stack) {
     *     1.) We are not taking any auxiliary data structure, hence extra space used is O(1).
     *     2.) However, we are using recursion, which does take recursion call stack space.
     *         The recursion can grow to the maximum depth of the tree.
     *         Hence, the recursive stack will take O(d) space where d = depth of tree.
     *
     *     Note: In the worst case, the depth of the tree can be equal
     *          to the number of nodes in the tree, if all nodes are linearly arranged.
     *          Hence, the recursion call stack can take O(n) space in the worst case.
     * }
     * @param node
     */
    public static void display(Node node){
        String str = node.data + " -> ";
        for (Node child : node.children){
            str += child.data + " , ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children){
            display(child);
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> stack = new Stack<>();
        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];

                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
        display(root);
    }
}
