package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class GenericTreeConstructor {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) {
     *     The time complexity of the above solution is O(n) as we are traversing
     *     the array which is filled with data of the nodes of the generic tree.
     * }
     *
     * Space Complexity -> O(N) {
     *     The space complexity of the above code is also O(n) as we have used a stack to create the tree.
     *     But, you may wonder why O(n). Can the stack have n elements in it at a time? Yes, it can.
     *     How? Think about this yourself!!!. (We will study this when we will study skewed trees).
     * }
     * @param args
     */
    public static void main(String[] args) {
        Node root;
         int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Stack<Node> stack = new Stack<>();

        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];

                if (stack.size()>0) {
                    Node peek = stack.peek();
                    peek.children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
    }
}
