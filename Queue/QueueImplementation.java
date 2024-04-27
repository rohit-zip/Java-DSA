package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {

        /**
         *
         * Queue is an interface which is implemented by Deque interface
         * Deque interface is implemented by ArrayDeque (Class)
         * Stack works on LIFO
         * Queue works on FIFO
         */
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        System.out.println(queue);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue);
        Integer peek = queue.peek();
        System.out.println(peek);
        queue.remove();

        //FIFO principal means 10 to be removed first
        System.out.println(queue);

        //Removes and Shows the first element
        Integer poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue);
        boolean offer = queue.offer(70);
        System.out.println(offer);
        System.out.println(queue);
    }
}
