package Arrays;

import java.security.DigestOutputStream;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class DecimalToAnyBase {
    /**
     * 
     * We had given Number (634), it's base 10(default)
     * and the base or number system to convert i.e 8
     * 
     * Divide ->   8  | 634
     *            ----|------       ^
     *             8  | 79 -> 2     \
     *            ----|------       \   Write in reverse Order
     *             8  | 9 -> 7      \       (1 1 7 2)
     *            ----|------       \
     *             8  | 1 -> 1      \
     *            ----|------       \
     *             8  | 0 -> 1      \
     * Approach
     *      1. Divide the no. and storre store it's remainder
     *      2. Multiply with 2 X 10^0  + 7 X 10^1 + 1 X 10^2 + 1 X 10^3
     *      3. Then add all the outcomes 2 + 70 + 100 + 1000
     *      4. Addition will be our answer
     * 
     * Why we have to do that
     *                  (634)₁₀ = (1172)₈
     *  (6*10² + 6*10¹ + 6*10⁰) = (1*8³ + 1*8² + 7*8¹ + 2*8⁰)
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
        
        int power=1;
        while(number>0){
            int digit = number % base;
            number = number/base;
            a = a + digit*power;
            power= power*10;
        }
        return a;
     }
}
