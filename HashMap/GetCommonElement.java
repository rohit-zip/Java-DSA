package HashMap;

import java.util.HashMap;

public class GetCommonElement {
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 2, 3, 5};
        int[] a2 = {1, 1, 1, 2, 2, 4, 5};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0 ; i<a1.length ; i++){
            if (hm.containsKey(a1[i])){
                int value = hm.get(a1[i]);
                int newFrequency = value + 1;
                hm.put(a1[i], newFrequency);
            } else {
                hm.put(a1[i], 1);
            }
        }

        for (int value : a2){
            if (hm.containsKey(value)){
                System.out.print(value + " ");
                hm.remove(value);
            }
        }

    }
}
