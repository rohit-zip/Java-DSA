package LinkedList;

public class ReverseKInLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addLast(6);
        list.addLast(1);
        list.addLast(7);
        list.addLast(2);
        list.addLast(4);
        list.addLast(8);
        list.addLast(5);
        list.addLast(10);
        list.addLast(16);
        list.display();

        list.reverseK(4);
        list.display();
    }

    public static class Node {
        int data;
        Node next;
    }

    public static class LinkedList {
        Node head;
        Node tail;
        int size;

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

        public int size() {
            return size;
        }

        public void display() {
            for (Node temp = head; temp != null; temp = temp.next) {
                System.out.print(temp.data + " ");
            }
            System.out.println();
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

        public int getLast() {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else {
                return tail.data;
            }
        }

        public int getAt(int idx) {
            if (size == 0) {
                System.out.println("List is empty");
                return -1;
            } else if (idx < 0 || idx >= size) {
                System.out.println("Invalid arguments");
                return -1;
            } else {
                Node temp = head;
                for (int i = 0; i < idx; i++) {
                    temp = temp.next;
                }
                return temp.data;
            }
        }

        public void addFirst(int val) {
            Node temp = new Node();
            temp.data = val;
            temp.next = head;
            head = temp;

            if (size == 0) {
                tail = temp;
            }

            size++;
        }

        public void addAt(int idx, int val) {
            if (idx < 0 || idx > size) {
                System.out.println("Invalid arguments");
            } else if (idx == 0) {
                addFirst(val);
            } else if (idx == size) {
                addLast(val);
            } else {
                Node node = new Node();
                node.data = val;

                Node temp = head;
                for (int i = 0; i < idx - 1; i++) {
                    temp = temp.next;
                }
                node.next = temp.next;

                temp.next = node;
                size++;
            }
        }

        public void removeLast() {
            if (size == 0) {
                System.out.println("List is empty");
            } else if (size == 1) {
                head = tail = null;
                size = 0;
            } else {
                Node temp = head;
                for (int i = 0; i < size - 2; i++) {
                    temp = temp.next;
                }

                tail = temp;
                tail.next = null;
                size--;
            }
        }

        public void oddEven(){
            LinkedList odd = new LinkedList();
            LinkedList even = new LinkedList();

            while(this.size>0){
                int value = this.getFirst();
                this.removeFirst();

                if (value%2==0) even.addLast(value);
                else odd.addLast(value);
            }

            if (odd.size>0 && even.size>0){
                odd.tail.next = even.head;
                this.head = odd.head;
                this.tail = even.tail;
                this.size = odd.size + even.size;
            } else if (odd.size>0) {
                this.head = odd.head;
                this.tail = odd.tail;
                this.size = odd.size;
            } else if (even.size > 0) {
                this.head = even.head;
                this.tail = even.tail;
                this.size = even.size;
            }
        }

        public void reverseK(int k){
            LinkedList prev = null;
            while(this.size>0){
                LinkedList curr = new LinkedList();
                if (this.size>=k) {
                    for (int i = 0; i < k; i++) {
                        int value = this.getFirst();
                        this.removeFirst();
                        curr.addFirst(value);
                    }
                }
                else {
                    int dynamicSize = this.size();
                    for (int i=0 ; i<dynamicSize ; i++){
                        int value = this.getFirst();
                        this.removeFirst();
                        curr.addLast(value);
                    }
                }

                if (prev==null){
                    prev = curr;
                }
                else {
                    prev.tail.next = curr.head;
                    prev.tail = curr.tail;
                    prev.size+=curr.size;
                }
            }

            this.head = prev.head;
            this.tail = prev.tail;
            this.size = prev.size;
        }
    }
}
