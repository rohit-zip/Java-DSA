package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInteger(String s){
        Map<Character, Integer> list = new HashMap<>();
        list.put('I', 1);
        list.put('V', 5);
        list.put('X', 10);
        list.put('L', 50);
        list.put('C', 100);
        list.put('D', 500);
        list.put('M', 1000);
        int result = list.get(s.charAt(s.length()-1));
        for (int i=s.length()-2 ; i>=0 ; i--){
            if (list.get(s.charAt(i))<list.get(s.charAt(i+1))){
                result-=list.get(s.charAt(i));
            } else {
                result+=list.get(s.charAt(i));
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "III";
        System.out.println(romanToInteger(s));
    }
}
