package Recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        /**
         *
         * You have given towers name and number of disks
         * Like Tower A,B and C
         * Transfer all disks from Tower A to Tower B using Tower C
         * You can only touch upper disk and one disk at a time
         */
        towerOfHanoi(3, 10, 11, 12);
    }

    public static void towerOfHanoi(int n, int t1, int t2, int t3){
        if (n==0) return;
        towerOfHanoi(n-1, t1, t3, t2);
        System.out.println(n + "[" + t1 + " -> " + t2 + "]");
        towerOfHanoi(n-1, t3, t2, t1);
    }
}
