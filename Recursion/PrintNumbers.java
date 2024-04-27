package Recursion;

public class PrintNumbers {

    public static void printNumbersIncreasing(int data){
        if (data==0){
            return;
        }
        printNumbersIncreasing(data-1);
        System.out.println(data);;
    }

    public static void printNumbersDecreasing(int data){
        if (data==0){
            return;
        }
        System.out.println(data);
        printNumbersDecreasing(data-1);
    }

    public static void main(String[] args) {
        printNumbersIncreasing(20);
        printNumbersDecreasing(20);
    }
}
