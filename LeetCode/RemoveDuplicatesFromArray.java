package LeetCode;

public class RemoveDuplicatesFromArray {

    public static int removeDuplicates(int[] nums){
        int counter = 1;
        for (int i=1 ; i<nums.length ; i++){
            if (nums[i]!=nums[i-1]){
                nums[counter] = nums[i];
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(array));
    }
}
