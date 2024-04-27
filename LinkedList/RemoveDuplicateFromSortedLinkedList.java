package LinkedList;

public class RemoveDuplicateFromSortedLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(2);
        linkedList.addFirst(2);
        linkedList.addFirst(2);
        linkedList.addFirst(4);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(5);
        linkedList.addFirst(5);
        linkedList.addFirst(5);
        linkedList.list();

        linkedList.removeDuplicate();
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

        void addLast(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;

            if (size == 0) {
                head = tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }

            size++;
        }

        public void removeFirst() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                head = head.next;
                size--;
            }
        }

        public int getFirst() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return head.data;
            }
        }

        public void list() {
            Node node = head;
            while (node != null) {
                if (node != tail) System.out.print(node.data + " -> ");
                else System.out.println(node.data);
                node = node.next;
            }
        }

        public void removeDuplicate(){
            LinkedList list = new LinkedList();
            while(this.size>0){
                int value = this.getFirst();
                this.removeFirst();

                if (list.size==0 || list.tail.data!=value){
                    list.addLast(value);
                }
            }
            this.head = list.head;
            this.tail = list.tail;
            this.size = list.size;
        }
    }
}
