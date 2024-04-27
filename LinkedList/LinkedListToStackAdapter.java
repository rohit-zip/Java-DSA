package LinkedList;

import java.util.LinkedList;

public class LinkedListToStackAdapter {
    public static void main(String[] args) {

        /*
          al rl gl -> Not Good as it took O(n) to remove last element
          af rf gf -> Superior
         */

        Adapter adapter = new Adapter();
        adapter.push(10);
        adapter.push(20);
        adapter.push(30);
        adapter.push(40);
        adapter.push(50);
        adapter.push(60);
        adapter.push(70);

        System.out.println(adapter.size());
    }

    public static class Adapter{
        LinkedList<Integer> list;

        public Adapter(){
            list = new LinkedList<>();
        }

        int size(){
            return list.size();
        }

        void push(int value){
            list.addFirst(value);
        }

        int pop(){
            if (size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else return list.removeFirst();
        }

        int top(){
            if (size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            else return list.getFirst();
        }
    }
}
