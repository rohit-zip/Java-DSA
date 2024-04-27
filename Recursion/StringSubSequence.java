package Recursion;

import java.util.ArrayList;

public class StringSubSequence {
    public static void main(String[] args) {
        ArrayList<String> strings = subSequence("abc");
        System.out.println(strings);
    }

    public static ArrayList<String> subSequence(String data){ //abc
        /**
         *
         *      abc
         *   -  b  c    |
         *   -  -  c    | <- subSequence(bc)
         *   -  b  -    |       If we add in front of
         *   -  -  -    |       it then we got the result
         *   a  -  -          subsequence(bc) + subSequence(bc) a
         *   a  -  c
         *   a  b  -
         *   a  b  c
         */

        if (data.length()==0){
            ArrayList<String> strings = new ArrayList<>();
            strings.add("");
            return strings;
        }
        char c = data.charAt(0);//a
        String substring = data.substring(1);//bc
        ArrayList<String> strings = subSequence(substring);

        ArrayList<String> nList = new ArrayList<>();
        for (String sequ : strings){
            nList.add("" + sequ);
            nList.add(c + sequ);
        }
        return nList;
    }
}
