package dp;

import java.util.Scanner;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Java Questions
 * Package - dp
 * Created_on - June 29 - 2024
 * Created_at - 12:52
 */

public class Fibonacci {

    public static int fibo(int n) {
        if (n==0 || n==1) {
            return n;
        }
        int fib1 = fibo(n-1);
        int fib2 = fibo(n-2);
        return fib1 + fib2;
    }

    public static int fiboMemoized(int n, int[] qb) {
        if (n==0 || n==1) {
            return n;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int fib1 = fibo(n-1);
        int fib2 = fibo(n-2);
        int f = fib1 + fib2;

        qb[n] = f;
        return f;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int fibn = fiboMemoized(n, new int[n+1]);
        System.out.println(fibn);
    }
}
