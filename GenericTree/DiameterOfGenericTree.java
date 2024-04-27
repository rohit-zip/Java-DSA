package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class DiameterOfGenericTree {

    static int diameter = 0;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node genericTree(int[] array){
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i : array){
            if (i==-1)
                stack.pop();
            else {
                Node temp = new Node();
                temp.data = i;
                if (stack.size()>0)
                    stack.peek().children.add(temp);
                else
                    root = temp;
                stack.push(temp);
            }
        }
        return root;
    }

    public static int calculateDiameterReturnHeight(Node root){
        int deepestChildHeight = -1;
        int secondDeepestChildHeight = -1;
        for (Node child : root.children){
            int childHeight = calculateDiameterReturnHeight(child);
            if (childHeight > deepestChildHeight){
                secondDeepestChildHeight = deepestChildHeight;
                deepestChildHeight = childHeight;
            } else if (childHeight > secondDeepestChildHeight){
                secondDeepestChildHeight = childHeight;
            }
        }
        if (deepestChildHeight + secondDeepestChildHeight + 2 > diameter){
            diameter = deepestChildHeight + secondDeepestChildHeight + 2;
        }
        deepestChildHeight+=1;
        return deepestChildHeight;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = genericTree(array);
        calculateDiameterReturnHeight(root);
        System.out.println(diameter);
    }
}
