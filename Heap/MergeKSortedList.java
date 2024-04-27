package Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedList {

    /**
     *
     * Priority Queue depends on Comparable
     */
    public static class Pair implements Comparable<Pair>{
        int listIndex;
        int dataIndex;
        int value;

        public Pair(int listIndex, int dataIndex, int value) {
            this.listIndex = listIndex;
            this.dataIndex = dataIndex;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i=0 ; i<lists.size() ; i++){
            Pair pair = new Pair(i, 0, lists.get(i).get(0));
            pq.add(pair);
        }

        while(pq.size()>0){
            Pair p = pq.remove();
            rv.add(p.value);
            p.dataIndex++;

            if (p.dataIndex < lists.get(p.listIndex).size()){
                p.value = lists.get(p.listIndex).get(p.dataIndex);
                pq.add(p);
            }
        }
        return rv;
    }

    /**
     *
     * We have K no. of Sorted list with different size
     * We have to Merge it all into new Sorted List
     */
    public static void main(String[] args) throws IOException {
        int[] a1 = {10, 20, 30, 40, 50};
        int[] a2 = {5, 7, 9, 11, 19, 55, 57};
        int[] a3 = {1, 2, 3};
        int[] a4 = {32, 39};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ArrayList<Integer> list = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            String[] elements = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(elements[j]));
            }

            lists.add(list);
        }

        ArrayList<Integer> mlist = mergeKSortedLists(lists);
        for (int val : mlist) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
