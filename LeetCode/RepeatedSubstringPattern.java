package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s){

//        int n = s.length();
//        for (int i=n/2 ; i>=1 ; i--){
//            if (n%i==0){
//                String substring = s.substring(0, i);
//                StringBuilder sb = new StringBuilder();
//                for (int j=1 ; j<=n/i ; j++){
//                    sb.append(substring);
//                }
//                if (sb.toString().equals(s)) return true;
//            }
//        }
//        return false;

        int n = s.length();
        String str = "";
        for (int i=1 ; i<=n/2 ; i++){
            if (n%i==0){
                str = s.substring(0, i);
                if (s.replaceAll(str, "").isEmpty()) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(repeatedSubstringPattern(s));
        String substring = s.substring(1, s.length() - 1);
        System.out.println(substring);
    }
}
