package LeetCode;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
//        String[] strings = s.trim().split(" ");
//        return strings[strings.length-1].length();
        int l = s.length()-1;
        int counter = 0;
        while(l>=0 && s.charAt(l)==' ') l--;
        while(l>=0 && s.charAt(l)!=' '){
            counter++;
            l--;
        }
        return counter;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lengthOfLastWord(s));
    }
}
