package LinkedList;

public class ReverseLinkedList {

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

        public Node getNodeAt(int index){
            Node temp = head;
            for (int i=0 ; i<index ; i++){
                temp = temp.next;
            }
            return temp;
        }

        public void reverseIterative(){
            int li = 0;
            int ri = size-1;
            while(li<ri){
                Node leftNode = getNodeAt(li);
                Node rightNode = getNodeAt(ri);
                int temp = leftNode.data;
                leftNode.data = rightNode.data;
                rightNode.data = temp;
                li++;
                ri--;
            }
        }

        public void reversePointer(){
            Node previous = null;
            Node current = head;

            while(current!=null){
                Node memory = current.next;
                current.next = previous;
                previous = current;
                current = memory;
            }
            //Swap the head and tail
            Node temp = head;
            head = tail;
            tail = temp;
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

        //Iterative Approach
        linkedList.reverseIterative();
        linkedList.list();

        //Pointer Approach
        linkedList.reversePointer();
        linkedList.list();
    }
}
