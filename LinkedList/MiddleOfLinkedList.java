package LinkedList;

public class MiddleOfLinkedList {

    public static void main(String[] args) {

        /*

            We use approach of Fast and Slow
            Initially both stands on Head
            Then Slow moves one step and fast runs two step
            When next of fast is null it means slow is at center
        */

        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(70);
        linkedList.addFirst(60);
        linkedList.addFirst(50);
        linkedList.addFirst(40);
        linkedList.addFirst(30);
        linkedList.addFirst(20);
        linkedList.addFirst(10);
        linkedList.list();
        System.out.println(linkedList.middleData());
    }

    static class Node {
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

        public void list() {
            Node node = head;
            while (node != null) {
                if (node != tail) System.out.print(node.data + " -> ");
                else System.out.println(node.data);
                node = node.next;
            }
        }

        public int middleData() {
            Node fast = head;
            Node slow = head;

            while (fast.next!=null && fast.next.next!=null) {
                fast = fast.next.next;
                slow = slow.next;
            }

            return slow.data;
        }
    }
}
