package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class LinearizeGenericTree {
    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(n²) { <br/>
     *     We have visited every node to linearize it. Although the leaf nodes do not get linearized, <br/>
     *     still we have visited them and so, we have visited n nodes. <br/>
     *     Also, when we visit them and try to linearize them, we visit all the nodes after linearizing <br/>
     *     in order to find the tail and add the next node in the pre-order to its children's ArrayList. <br/>
     *     This happens inside the first loop of traversal. So, in a way- we have a nested loop where we <br/>
     *     are visiting almost n elements every time. So, the time complexity is O(n2). <br/>
     * } <br/>
     * Space Complexity -> O(1)
     * @param root
     */
    public static void linearize(Node root) {
        for (Node child : root.children) {
            linearize(child);
        }
        while (root.children.size() > 1) {
            Node lastChild = root.children.remove(root.children.size() - 1);
            Node secondLastChild = root.children.get(root.children.size() - 1);
            Node secondLastTail = getTail(secondLastChild);
            secondLastTail.children.add(lastChild);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    public static void display(Node node) {
        String str = node.data + " -> ";
        for (Node child : node.children) {
            str += child.data + " , ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children) {
            display(child);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == -1) {
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];
                if (stack.size() > 0) {
                    stack.peek().children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
        linearize(root);
        display(root);
    }
}
