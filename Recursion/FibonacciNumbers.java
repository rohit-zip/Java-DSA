package Recursion;

public class FibonacciNumbers {

    /**
     *
     * Fibonacci number is sum of previous two Fibonacci numbers fn= fn-1+ fn-2
     * First 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
     */

    public static int fibonacci(int data){

        if (data==0){
            return 0;
        }
        if (data==1 || data==2){
            return 1;
        }
        return fibonacci(data-1) + fibonacci(data-1);
    }
    public static void main(String[] args) {
        int fibonacci = fibonacci(10);
        for (int i=0 ; i<10 ; i++){
            System.out.print(fibonacci(i) + " ");
        }
    }
}
