package LinkedList;

import java.util.LinkedList;

public class LinkedListToQueueAdapter {
    public static void main(String[] args) {
        /*

            Queue works on FIFO
            So we can achieve this by addLast and removeFirst
         */

        QueueAdapter queueAdapter = new QueueAdapter();
        queueAdapter.push(10);
        queueAdapter.push(20);
        queueAdapter.push(30);
        queueAdapter.push(40);
        queueAdapter.push(50);
        queueAdapter.push(60);
        queueAdapter.push(70);
        queueAdapter.push(80);
        System.out.println(queueAdapter.size());
    }

    public static class QueueAdapter{
        LinkedList<Integer> list;

        public QueueAdapter(){
            list = new LinkedList<>();
        }

        int size(){
            return list.size();
        }

        void push(int value){
            list.addLast(value);
        }

        int pop(){
            if (size()==0) return -1;
            else return list.removeFirst();
        }

        int top(){
            if (size()==0) return -1;
            else return list.getFirst();
        }
    }
}
