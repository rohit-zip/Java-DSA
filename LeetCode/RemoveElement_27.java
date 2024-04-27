package LeetCode;

public class RemoveElement_27 {

    public static int removeElement(int[] nums, int val) {

        //Here we are using swapping technique
        int i = 0;
        for(int a : nums){
            if (a!=val){
                int temp = a;
                a = nums[i];
                nums[i] = temp;
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] array = {3,2,2,3};
        int val = 3;
        System.out.println(removeElement(array, val));
    }
}
