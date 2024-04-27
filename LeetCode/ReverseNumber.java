package LeetCode;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 7566745;
        int reverse = 0;
        int original = n;
        while(n>0){
            reverse = n%10 + reverse*10;
            n = n/10;
        }
        System.out.println(reverse);
    }
}
