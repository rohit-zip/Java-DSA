package LinkedList;

public class KthNodeFromLast {
    public static void main(String[] args) {
        /*

                We can use two Nodes one is slow and other is fast
                Firstly we will move fast Node to Kth index
                Then iterate both till Fast reaches at the tail
                As soon as Fast one reaches tail that means Slow one is at K position from last
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
        System.out.println(linkedList.kthFromLast(2));
    }

    static class Node{
        Node next;
        int data;
    }

    public static class LinkedList {
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

        public void list(){
            Node node = head;
            while(node!=null){
                if (node!=tail) System.out.print(node.data + " -> ");
                else System.out.println(node.data);
                node = node.next;
            }
        }

        public int kthFromLast(int k){
            Node slow = head;
            Node fast = head;

            for (int i=0 ; i<k ; i++) fast = fast.next;
            while(fast!=tail){
                slow = slow.next;
                fast = fast.next;
            }

            return slow.data;
        }

    }
}
