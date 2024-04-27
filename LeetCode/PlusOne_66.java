package LeetCode;

public class PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        int digit = digits[digits.length-1] + 1;
        int c = digit/10;
        digit = digit%10;
        digits[digits.length-1] = digit;
        for (int i=digits.length-2 ; i>=0 ; i--){
            int d = 0;
            if (c!=0){
                d = digits[i] + c;
                c = d/10;
                d = d%10;
                digits[i] = d;
            }
        }
        if (c!=0){
            int[] newArray = new int[digits.length+1];
            newArray[0] = c;
            for (int i=0 ; i<digits.length ; i++){
                newArray[i+1] = digits[i];
            }
            return newArray;
        }
        return digits;
    }

    public static int[] plusOneEfficientApproach(int[] digits){
        for (int i=digits.length-1 ; i>=0 ; i--){
            if (digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int[] ints = plusOne(nums);
        for (int a : ints){
            System.out.print(a + " ");
        }
    }
}
