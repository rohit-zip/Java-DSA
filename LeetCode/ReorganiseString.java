package LeetCode;

import java.util.*;

public class ReorganiseString {

    private static class Pair{
        char ch;
        int freq;

        public Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    /**
     *
     * Pseudo Code :-
     * 1.) Create HashMap
     * 2.) Create Priority Queue
     * 3.) Initialize all elements in PriorityQueue
     * 4.) Base Case -> remove
     *               -> Update in Answer
     *               -> Decrease Frequency
     *               -> Put element in Block
     * 5.) while(PQ>0){
     *     1. Create temp
     *     2. Update Answer
     *     3. Decrease Frequency
     *     4. if (block frequency > 0) push to priority queue
     *     5. block = temp
     *     }
     */
    public static String reorganiseString(String s){
        int[] map = new int[26];
        for (int i=0 ; i<s.length() ; i++){
            map[s.charAt(i)-'a']++;
        }

        //Max PriorityQueue
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> (b.freq - a.freq));

        for (int i=0 ; i<map.length ; i++){
            if (map[i]>0)
                pq.add(new Pair((char)('a' + i), map[i]));
        }
        StringBuilder sb = new StringBuilder();
        Pair block = pq.poll();
        sb.append(block.ch);
        block.freq--;
        while(pq.size()>0){
            Pair temp = pq.poll();
            sb.append(temp.ch);
            temp.freq--;
            if (block.freq>0){
                pq.add(block);
            }
            block = temp;
        }
        if (block.freq>0) return "";
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "vvvnffvafdd";
        System.out.println(reorganiseString(s));
    }
}
