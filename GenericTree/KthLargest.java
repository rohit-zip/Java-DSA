package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class KthLargest {

    static int floor;
    static int ceil;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node genericTree(int[] array){
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i : array){
            if (i==-1)
                stack.pop();
            else {
                Node temp = new Node();
                temp.data = i;
                if (stack.size() > 0) {
                    stack.peek().children.add(temp);
                } else
                    root = temp;
                stack.push(temp);
            }
        }
        return root;
    }

    public static void ceilFloor(Node root, int data){
        if (root.data > data){
            if (root.data < ceil){
                ceil = root.data;
            }
        }
        if (root.data < data){
            if (root.data > floor){
                floor = root.data;
            }
        }
        for (Node child : root.children){
            ceilFloor(child, data);
        }
    }

    public static int kthLargestElement(Node root, int k){
        floor = Integer.MIN_VALUE;
        int factor = Integer.MAX_VALUE;
        for (int i=0 ; i<k ; i++){
            ceilFloor(root, factor);
            factor = floor;
            floor = Integer.MIN_VALUE;
        }
        return factor;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = genericTree(array);
        System.out.println(kthLargestElement(root, 2));
    }
}
