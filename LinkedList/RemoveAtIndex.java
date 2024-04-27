package LinkedList;

public class RemoveAtIndex {
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

        private Node getNodeAt(int index){
            Node temp = head;
            for (int i=0 ; i<index ; i++)
                temp = temp.next;
            return temp;
        }

        public void removeAt(int index){
            if (index<0 || index>=size) System.out.println("Invalid Index");
            if (size==0) System.out.println("Size Zero");
            if (size==1) head = tail = null;
            Node nodeAt = getNodeAt(index - 1);
            nodeAt.next = getNodeAt(index + 1);
            size--;
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
        linkedList.removeAt(5);
        linkedList.list();
    }
}
