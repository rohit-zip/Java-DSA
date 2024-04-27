package Recursion;

public class ReverseString {

    public static String reverse(String data){
        if (data.length()==0){
            return data;
        }
//        System.out.println(data.substring(1) + data.charAt(0));
        return reverse(data.substring(1)) + data.charAt(0);
    }
    public static void main(String[] args) {
        String rohit = reverse("ROHIT");
        System.out.println(rohit);
    }
}
