package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class NodeToRootPath {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(nlogn) (Equal to the height of the tree due to the recursion stack) <br/>
     * @param root
     * @param data
     * @return
     */
    public static ArrayList<Integer> nodeToRootPath(Node root, int data){
        if (root.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }
        for (Node child : root.children){

            //ptc = path to child
            ArrayList<Integer> ptc = nodeToRootPath(child, data);

            //Means child has the data, so add the child to list and return
            if (ptc.size()>0){
                ptc.add(root.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i : array){
            if (i==-1)
                stack.pop();
            else {
                Node node = new Node();
                node.data = i;
                if (stack.size()>0)
                    stack.peek().children.add(node);
                else
                    root = node;
                stack.push(node);
            }
        }
        System.out.println(nodeToRootPath(root, 110));
    }
}
