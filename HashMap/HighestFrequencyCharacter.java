package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class HighestFrequencyCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i=0 ; i<str.length() ; i++){
            char ch = str.charAt(i);
            if (hm.containsKey(ch)){
                Integer value = hm.get(ch);
                int newFrequency = value + 1;
                hm.put(ch, newFrequency);
            } else {
                hm.put(ch, 1);
            }
        }

        char maxFrequencyCharacter = str.charAt(0);
        for (Character key : hm.keySet()){
            if (hm.get(key) > hm.get(maxFrequencyCharacter)){
                maxFrequencyCharacter = key;
            }
        }

        System.out.println(maxFrequencyCharacter);
    }
}
