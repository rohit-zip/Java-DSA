package HashMap;

import java.util.HashMap;

public class AllCommonElements {
    public static void main(String[] args) {
        int[] a1 = {1, 1, 2, 2, 2, 3, 5};
        int[] a2 = {1, 1, 1, 2, 2, 4, 5};

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int key : a1){
            if (hm.containsKey(key)){
                Integer value = hm.get(key);
                int nf = value + 1;
                hm.put(key, nf);
            } else {
                hm.put(key, 1);
            }
        }

        for (int key : a2){
            if (hm.containsKey(key) && hm.get(key)>0){
                    System.out.print(key + " ");
                    Integer value = hm.get(key);
                    int nf = value - 1;
                    hm.put(key, nf);
            }
        }
    }
}
