package LinkedList;

public class MergeSortLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast(10);
        linkedList.addLast(7);
        linkedList.addLast(6);
        linkedList.addLast(2);
        linkedList.addLast(8);
        linkedList.addLast(5);
        linkedList.addLast(1);
        linkedList.list();

        LinkedList mergedList = mergeSort(linkedList.head, linkedList.tail);
        mergedList.list();
    }

    private static class Node{
        Node next;
        int data;
    }

    private static class LinkedList{
        Node head;
        Node tail;
        int size;

        public void addFirst(int value){
            Node node = new Node();
            node.data = value;
            node.next = head;
            head = node;
            if (size==0){
                tail = node;
            }
            size++;
        }

        public void addLast(int value){
            Node node = new Node();
            node.data = value;
            node.next = null;
            if (size==0){
                node = head = tail;
            }
            else {
                tail.next = node;
                tail = node;
            }
            size++;
        }

        public void list(){
            Node node = head;
            while(node!=null){
                if (node!=tail) System.out.print(node.data + " -> ");
                else System.out.println(node.data);
                node = node.next;
            }
        }
    }

    private static Node midNode(Node head, Node tail){
        Node fast = head;
        Node slow = tail;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private static LinkedList mergeList(LinkedList a, LinkedList b){
        Node a1 = a.head;
        Node b1 = b.head;

        LinkedList linkedList = new LinkedList();

        while(a1!=null && b1!=null){
            if (a1.data<b1.data){
                linkedList.addLast(a1.data);
                a1 = a1.next;
            }
            else {
                linkedList.addLast(b1.data);
                b1 = b1.next;
            }
        }

        while(a1!=null){
            linkedList.addLast(a1.data);
            a1 = a1.next;
        }

        while(b1!=null){
            linkedList.addLast(b1.data);
            b1 = b1.next;
        }

        return linkedList;
    }

    private static LinkedList mergeSort(Node head, Node tail){
        if (head==tail){
            LinkedList linkedList = new LinkedList();
            linkedList.addLast(head.data);
            return linkedList;
        }
        Node middleNode = midNode(head, tail);
        LinkedList initial = mergeSort(head, middleNode);
        LinkedList b = mergeSort(middleNode.next, tail);
        LinkedList mergedList = mergeList(initial, b);
        return mergedList;
    }
}
