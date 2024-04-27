package Recursion;

import java.util.ArrayList;

public class KeypadCombinations {

    /**
     *
     * 1 -> abc
     * 2 -> def
     * 3 -> ghi
     * 4 -> jkl
     * 5 -> mnop
     * 6 -> qrst
     * 7 -> uv
     * 8 -> wxyz
     * 9 -> .;
     * 0 -> ?!
     * @param args
     */
    public static void main(String[] args) {

        /**
         *
         * Example User entered 672
         *
         *  6   7   2
         *  q   u   d -> Combinations(4 * 2 * 3 = 24)
         *  r   v   e
         *  s       f
         *  t
         *
         *  Answer -> qud, que, quf, qvd, qve, qvf, rud, rue, ruf, rvd, rve, rvf, etc
         *
         *  Expectation -> Method(672) will give us our answer
         *  Faith -> Method(72) will give all combinations for 72
         */

        ArrayList<String> combinations = getCombinations("672");
        System.out.println(combinations);
    }

    //Global Array
    static String[] keys = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getCombinations(String data){
        if (data.length()==0){
            ArrayList<String> strings = new ArrayList<>();
            strings.add("");
            return strings;
        }
        char ch = data.charAt(0); //6
        String subData = data.substring(1); //72
        ArrayList<String> combinations = getCombinations(subData); //6 words of 72
        ArrayList<String> list = new ArrayList<>();
        String key = keys[ch - '0'];
        for (int i=0 ; i<key.length() ; i++){
            char c = key.charAt(i);
            for (String a : combinations){
                list.add(c + a);
            }
        }
        return list;
    }
}
