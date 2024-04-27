package Heap;

import java.util.PriorityQueue;

public class PriorityQueueDataStructure {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(100);
        pq.add(10);
        pq.add(20);
        pq.add(70);
        pq.add(40);
        pq.add(80);
        pq.add(60);

        System.out.println(pq);
    }
}
