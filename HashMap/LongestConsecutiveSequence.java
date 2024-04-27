package HashMap;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] array = {10, 5, 9, 1, 11, 8, 6, 15, 3, 12, 2};

        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int value : array)
            hm.put(value, true);

        //If Value contains it's lesser value in map then it means it is not the starting point of the sequence
        for (int value : array){
            if (hm.containsKey(value - 1)){
                hm.put(value, false);
            }
        }

        int msp = 0;
        int ml = 0;
        for (int val : array){
            if (hm.get(val)){
                int tl = 1;
                int tsp = val;

                while(hm.containsKey(tsp + tl)){
                    tl++;
                }

                if (tl>ml){
                    msp = tsp;
                    ml = tl;
                }
            }
        }

        for (int i=0 ; i<ml ; i++)
            System.out.println(msp + i);
    }
}
