package LinkedList;


public class MergeTwoSortedLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(5);
        list.addLast(8);
        list.addLast(10);
        list.addLast(16);
        list.addLast(17);
        list.addLast(18);

        list.list();

        LinkedList list1 = new LinkedList();
        list1.addLast(2);
        list1.addLast(7);
        list1.addLast(11);
        list1.addLast(15);

        list1.list();

        LinkedList linkedList = mergeList(list, list1);
        linkedList.list();
    }

    static class Node{
        Node next;
        int data;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

        public void addFirst(int value) {
            Node node = new Node();
            node.data = value;
            node.next = head;
            head = node;
            if (size == 0) {
                tail = node;
            }
            size++;
        }

        public void addLast(int value){
            Node node = new Node();
            node.data = value;
            node.next = null;
            if (size==0) {
                tail = head = node;
            }
            else {
                tail.next = node;
                tail = node;
            }
            size ++;
        }

        public void list() {
            Node node = head;
            while (node != null) {
                if (node != tail) System.out.print(node.data + " -> ");
                else System.out.println(node.data);
                node = node.next;
            }
        }
    }

    public static LinkedList mergeList(LinkedList list, LinkedList list1) {
        Node a = list.head;
        Node b = list1.head;
        LinkedList linkedList = new LinkedList();
        while (a!=null && b!=null){
            if (a.data<b.data){
                linkedList.addLast(a.data);
                a = a.next;
            }
            else {
                linkedList.addLast(b.data);
                b = b.next;
            }
        }

        while(a!=null){
            linkedList.addLast(a.data);
            a = a.next;
        }

        while(b!=null){
            linkedList.addLast(b.data);
            b = b.next;
        }

        return linkedList;
    }
}
