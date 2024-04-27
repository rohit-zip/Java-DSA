package HashMap;

import java.util.HashMap;
import java.util.Set;

public class HashMaps {

    /**
     *
     * We don't have control over order in HashMaps
     */
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 140);
        hm.put("China", 145);
        hm.put("Pakistan", 40);
        hm.put("US", 20);
        hm.put("UK", 10);

        System.out.println(hm);

        hm.put("Nigeria", 5);
        hm.put("US", 25);

        System.out.println(hm);

        System.out.println(hm.get("India"));
        System.out.println(hm.get("Utopia"));

        System.out.println(hm.containsKey("India"));
        System.out.println(hm.containsKey("Utopia"));

        Set<String> keys = hm.keySet();
        System.out.println(keys);

        for (String key : hm.keySet()){
            Integer values = hm.get(key);
            System.out.println(key + " -> " + values);
        }
    }
}
