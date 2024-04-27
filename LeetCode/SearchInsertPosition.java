package LeetCode;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if (target>nums[mid]) lo = mid+1;
            if (target<nums[mid]) hi = mid-1;
            if (target==nums[mid])return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert(nums, target));
    }
}
