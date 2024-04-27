package Recursion;

public class OptimisedPower {

    public static int power(int number, int p){

        /**
         *
         * 2^8 -> 2^(8/2) * 2^(8/2)
         * 2^9 -> 2^(4) * 2^(4) * 2
         */

        if (p==0) return 1;
        int a = power(number, p/2);
        int b = a*a;

        if (p%2==1) b = b*number;
        return b;
    }
    public static void main(String[] args) {
        int power = power(2, 8);
        System.out.println(power);
    }
}
