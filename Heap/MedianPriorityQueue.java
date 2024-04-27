package Heap;

import java.util.PriorityQueue;

public class MedianPriorityQueue {

    public static class MedianPQ {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;

        public MedianPQ(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
            this.left = left;
            this.right = right;
        }

        public void add(int value) {
            if (right.size() > 0 && value > right.peek()){
                right.add(value);
            } else {
                left.add(value);
            }

            if (left.size() - right.size() ==2){
                right.add(left.remove());
            } else if (right.size() -left.size() ==2){
                left.add(right.remove());
            }
        }

        public int remove() {
            if (this.size() == 0) {
                System.err.println("Underflow");
                return -1;
            } else if (left.size() >= right.size())
                return left.remove();
            else
                return right.remove();
        }

        public int peek() {
            if (this.size() == 0) {
                return -1;
            } else if (left.size() >= right.size()) {
                return left.peek();
            } else {
                return right.peek();
            }
        }

        public int size() {
            return left.size() + right.size();
        }
    }

    /**
     * Peek -> Give element from left or right whose size is greater, if size equal then give from left
     * Remove ->  ---------------------------------------"---------------------------------------------
     * Add -> Generally add in left. In case if there is element in right and data is greater than peek
     * of right then add on right. After adding we have to take care of balancing
     */
    public static void main(String[] args) {

    }
}
