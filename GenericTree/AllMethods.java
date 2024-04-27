package GenericTree;

import com.sun.jdi.IntegerType;

import java.util.*;

public class AllMethods {

    static int size;
    static int min;
    static int max;
    static int height;
    static int  state;
    static Node predecessor;
    static Node successor;
    static int ceil = 0;
    static int floor = 0;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node genericTree(int[] array){
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i : array){
            if (i==-1){
                stack.pop();
            } else {
                Node node = new Node();
                node.data = i;
                if (stack.size()>0){
                    stack.peek().children.add(node);
                } else {
                    root = node;
                }
                stack.push(node);
            }
        }
        return root;
    }

    public static void display(Node root){
        StringBuilder str = new StringBuilder(root.data + " -> ");
        for (Node child : root.children){
            str.append(child.data).append(",");
        }
        str.append(".");
        System.out.println(str);
        for (Node child : root.children){
            display(child);
        }
    }

    public static int size(Node root){
        int size = 0;
        for (Node child : root.children){
            int childSize = size(child);
            size += childSize;
        }
        size += 1;
        return size;
    }

    public static int max(Node root){
        int max = Integer.MIN_VALUE;
        for (Node child : root.children){
            int childMax = max(root);
            max = Math.max(childMax, max);
        }
        max = Math.max(max, root.data);
        return max;
    }

    public static int height(Node root){
        int height = -1;
        for (Node child : root.children){
            int childHeight = height(child);
            height = Math.max(height, childHeight);
        }
        height += 1;
        return height;
    }

    public static void traversal(Node root){
        System.out.println("Node Pre : " + root.data);
        for (Node child : root.children){
            System.out.println("Edge Pre : " + root.data + " -- " + child.data);
            traversal(child);
            System.out.println("Edge Post : " + root.data + " -- " + child.data);
        }
        System.out.println("Node Post : " + root.data);
    }

    public static void levelOrderTraversal(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0){
            root = queue.remove();
            System.out.print(root.data + " ");
            for (Node child : root.children){
                queue.add(child);
            }
        }
    }

    public static void levelOrderLineWise(Node root){
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(root);
        while(mq.size()>0){
            root = mq.remove();
            System.out.print(root.data + " ");
            for (Node child : root.children){
                cq.add(child);
            }
            if (mq.size()==0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }

    public static void lineWiseZigZag(Node root){
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(root);
        int level = 1;
        while(ms.size()>0){
            root = ms.pop();
            System.out.print(root.data + " ");
            if (level%2==1){
                for (int i=0 ; i<root.children.size() ; i++){
                    Node child = root.children.get(i);
                    cs.push(child);
                }
            } else {
                for (int i=root.children.size()-1 ; i>=0 ; i--){
                    Node child = root.children.get(i);
                    cs.push(child);
                }
            }
            if (ms.size()==0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void mirror(Node root){
        for (Node child : root.children){
            mirror(root);
        }
        Collections.reverse(root.children);
    }

    public static void removeLeafs(Node root){
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

    public static void linearize(Node root){
        for (Node child : root.children){
            linearize(child);
        }
        while(root.children.size()>1){
            Node lastChild = root.children.remove(root.children.size() - 1);
            Node secondLastChild = root.children.get(root.children.size() - 1);
            Node tail = getTail(secondLastChild);
            tail.children.add(lastChild);
        }
    }

    private static Node getTail(Node root){
        while (root.children.size()==1){
            root = root.children.get(0);
        }
        return root;
    }

    public static boolean findElement(Node root, int data){
        if (root.data==data){
            return true;
        }
        for (Node child : root.children){
            boolean element = findElement(child, data);
            if (element){
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> nodeToRootPath(Node root, int data){
        if (root.data==data){
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(root.data);
            return arrayList;
        }
        for (Node child : root.children){
            ArrayList<Integer> list = nodeToRootPath(child, data);
            if (list.size() > 0) {
                list.add(root.data);
                return list;
            }
        }
        return new ArrayList<>();
    }

    public static int lowestCommonAncestor(Node root, int p1, int p2){
        ArrayList<Integer> a1 = nodeToRootPath(root, p1);
        ArrayList<Integer> a2 = nodeToRootPath(root, p2);
        int i = a1.size()-1;
        int j = a2.size()-1;
        while(i>0 && j>0 && a1.get(i)==a2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return a1.get(i);
    }

    public static int distanceBetweenTwoNodes(Node root, int p1, int p2){
        ArrayList<Integer> a1 = nodeToRootPath(root, p1);
        ArrayList<Integer> a2 = nodeToRootPath(root, p2);
        int i = a1.size()-1;
        int j = a2.size()-1;
        while(i>0 && j>0 && a1.get(i)==a2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }

    public static boolean areSimilar(Node a, Node b){
        if (a.children.size()!=b.children.size()){
            return false;
        }
        for (int i=0 ; i<a.children.size() ; i++){
            boolean isSimilar = areSimilar(a.children.get(i), b.children.get(i));
            if (!isSimilar)
                return false;
        }
        return true;
    }

    public static boolean areMirror(Node a, Node b){
        if (a.children.size()!=b.children.size())
            return false;
        for (int i=0 ; i<a.children.size() ; i++){
            Node a1 = a.children.get(i);
            Node b1 = b.children.get(b.children.size()-1-i);
            if (!areSimilar(a1, b1))
                return false;
        }
        return true;
    }

    public static boolean isSymmetric(Node a, Node b){
        return areMirror(a, b);
    }

    public static void multisolver(Node root, int depth){
        size++;
        min = Math.min(root.data, min);
        max = Math.max(root.data, max);
        height = Math.max(height, depth);
        for (Node child : root.children){
            multisolver(child, depth+1);
        }
    }

    public static void predecessorSuccessor(Node root, int data){
        if (state==0){
            if (root.data==data){
                state = 1;
            } else {
                predecessor = root;
            }
        } else if (state==1){
            successor = root;
            state = 2;
        }
        for (Node child : root.children){
            predecessorSuccessor(child, data);
        }
    }

    public static void ceilFloor(Node root, int data){
        if (root.data > data){
            if (ceil > root.data)
                ceil = root.data;
        }

        if (root.data < data){
            if (root.data > floor){
                floor = root.data;
            }
        }
        for (Node child : root.children)
            ceilFloor(child, data);
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
    }
}
