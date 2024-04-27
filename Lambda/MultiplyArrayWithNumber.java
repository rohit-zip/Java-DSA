package Lambda;

import java.util.ArrayList;

public class MultiplyArrayWithNumber {

    public static void multiply(ArrayList<Integer> list, int data){
        list.replaceAll(number-> number * data);
        System.out.println(list);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        multiply(list, 4);
    }
}
