package Arrays;

public class DigitsCounter {

    public static int getDigitsCounter(int n, int d){
        int rv=0;

        while(n>0){
            int digit = n%10;
            n = n/10;

            if(digit==d){
                rv++;
            }
        }
        return rv;
    }
    public static void main(String[] args) {
        int digitsCounter = getDigitsCounter(756754645, 5);
        System.out.println("Digit Counter : " + digitsCounter);
    }
}
