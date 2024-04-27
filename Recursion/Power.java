package Recursion;

public class Power {

    public static int power(int n, int p){
        if (p==0) return 1;
        return n * power(n, p-1);
//        return (int) (n*Math.pow(n,p-1));
    }
    public static void main(String[] args) {
        int power = power(3, 2);
        System.out.println(power);
    }
}