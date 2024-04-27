package Recursion;

public class ZigZag {
    public static void main(String[] args) {
        zigZag(2);
    }

    public static void zigZag(int data){
        if (data==0){
            return;
        }
        System.out.println("Pre : " + data);
        zigZag(data-1);
        System.out.println("In : " + data);
        zigZag(data-1);
        System.out.println("Post : " + data);
    }
}
