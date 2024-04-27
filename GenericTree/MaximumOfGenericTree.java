package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class MaximumOfGenericTree {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

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

    public static int size(Node node){
        int size = 0;
        for (Node child : node.children){
            int size1 = size(child);
            size += size1;
        }
        size = size + 1;
        return size;
    }

    /**
     *
     * Time Complexity -> O(N)
     * Space Complexity -> { <br/>
     *     Without Considering Recursion Space: Since we have not used any extra <br/>
     *     data structure therefore the space complexity of this solution is O(1). <br/>
     *     <br/>
     *     Considering the Recursion Space: If we consider the recursion space <br/>
     *     then the stack has at most logn elements in it at a time <br/>
     *     (we will learn about this later in this section). <br/>
     *     So, the space complexity considering the recursion space will be O(logn). <br/>
     * }
     * @param node
     * @return
     */
    public static int max(Node node){
        int max = Integer.MIN_VALUE;
        for (Node child : node.children){
            int childMax = max(child);
            max = Math.max(childMax, max);
        }
        max = Math.max(node.data, max);
        return max;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
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
                    temp = root;
                }
                stack.push(temp);
            }
        }
        System.out.println(max(root));
    }
}
