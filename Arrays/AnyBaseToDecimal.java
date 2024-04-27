package Arrays;

import java.util.Scanner;

public class AnyBaseToDecimal {
    /**
     * 
     * We had given Number with any Base (1172)₈,
     * convert it to Decimal (634)₁₀
     * 
     * Divide ->   10 | 1172
     *            ----|------       ^
     *             10 | 117 -> 2 * 8⁰    \
     *            ----|------            \   Write in reverse Order
     *             10 | 11 -> 7 * 8¹     \       (1 1 7 2)
     *            ----|------       \
     *             10 | 1 -> 1 * 8²     \
     *            ----|------       \
     *                | 0 -> 1 * 8³     \
     * Approach
     *      1. Divide the no. and store it's remainder
     *      2. Multiply with 1*8³ + 1*8² + 7*8¹ + 2*8⁰
     *      3. Then add all the outcomes 2 + 56 + 64 + 512
     *      4. Addition will be our answer
     * 
     * Why we have to do that
     *                      (1172)₈ = (634)₁₀
     *  (1*8³ + 1*8² + 7*8¹ + 2*8⁰) = (6*10² + 6*10¹ + 6*10⁰)
     */

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number : ");
        int number = sc.nextInt();
        System.out.println("Enter Base : ");
        int base = sc.nextInt();

        System.out.println("Conversion is : ");
        System.out.println(convert(number, base));
     }

     public static int convert(int number, int base){
        int a = 0;

        int p=1;
        while(number>0){
            int digit = number % 10;
            number = number/10;

            a = a + digit*p;
            p = p*base;
        }
        return a;
     }
}
