package Arrays;

public class AnyBaseAddition {

    public int baseAddition(int number1, int number2, int base){
        int a = 0;
        int c = 0;
        int p = 1;

        while(number1>0 || number2>0 || c>0){
            int d1 = number1 % 10;
            int d2 = number2 % 10;
            number1 = number1/10;
            number2 = number2/10;

            int d = d1 + d2 + c;
            c = d/base;
            d = d%base;
            a+= d * p;
            p = p*10;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new AnyBaseAddition().baseAddition(236,754,8));
    }
}
