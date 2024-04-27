package Heap;

import java.util.PriorityQueue;

public class HeapSorting {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] array = {10, 2, 60, 14, 70, 16, 100, 50, 25, 55};

        //Time Complexity -> O(nlogn)
        for (int value : array){
            pq.add(value);
        }

        while(pq.size()>0){
            System.out.print(pq.peek() + " < ");
            pq.remove();
        }
    }
}
