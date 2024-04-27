package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class LowestCommonAncestor {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static ArrayList<Integer> nodeToRootPath(Node root, int data){
        if (root.data == data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }
        for (Node child : root.children){
            ArrayList<Integer> ptc = nodeToRootPath(child, data);
            if (ptc.size()>0){
                ptc.add(root.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N)
     * Space Compelexity -> O(N) Storing in Arraylist
     * @param node
     * @param p1
     * @param p2
     * @return
     */
    public static int lowestAncestor(Node node, int p1, int p2){
        ArrayList<Integer> list1 = nodeToRootPath(node, p1);
        ArrayList<Integer> list2 = nodeToRootPath(node, p2);
        int i = list1.size() - 1;
        int j = list2.size() - 1;

        while(i>=0 && j>=0 && list1.get(i) == list2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return list1.get(i);
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = null;
        Stack<Node> stack = new Stack<>();
        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];
                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else{
                    root = temp;
                }
                stack.push(temp);
            }
        }
        System.out.println(lowestAncestor(root, 110, 70));
    }
}
