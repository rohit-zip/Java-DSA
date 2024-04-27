package Hashing;

import java.util.HashSet;
import java.util.Set;

public class DistinctElements {
    public static void main(String[] args) {
        int[] array = {1,4,5,2,5,1,7,5,8,5};
        Set<Integer> list = new HashSet<>();
        for (int a : array){
            list.add(a);
        }
        System.out.println(list.size());
    }
}
