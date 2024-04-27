package Recursion;

public class Factorial {

    public static int factorial(int data){
        if (data==1){
            return 1;
        }
        return data * factorial(data - 1);
    }
    public static void main(String[] args) {
        int factorial = factorial(5);
        System.out.println(factorial);
    }
}
