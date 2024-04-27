package LinkedList;

public class LinkedListFromScratch {

    static class Node{
        Node next;
        int data;
    }

    public static class LinkedList{
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
    }
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(10);
        linkedList.addFirst(20);
        linkedList.addFirst(40);
        linkedList.addFirst(50);
        linkedList.addFirst(60);
        linkedList.addFirst(70);
        linkedList.list();
    }
}
