package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveLeafsFromGenericTree {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N)
     * Space Complexity -> O(1)
     * @param root
     */
    public static void removeLeafs(Node root){
        // Writing logic in Pre order so that code will not confuse between already leafs and created leafs
        for (int i=root.children.size()-1 ; i>=0 ; i--){
            Node child = root.children.get(i);
            if (child.children.isEmpty()){
                root.children.remove(child);
            }
        }
        for (Node child : root.children){
            removeLeafs(child);
        }
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
                } else{
                    root = temp;
                }
                stack.push(temp);
            }
        }
        System.out.println("Generic Tree");
        display(root);
        System.out.println("Removed Leafs");
        removeLeafs(root);
        display(root);
    }
}
