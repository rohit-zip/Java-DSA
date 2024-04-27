package Recursion;

public class Overview {
    public static void numbers(int data){
        if (data==0) return;
        System.out.println(data);  // 5
        numbers(data-1);   // numbers(4)
    }

    public static void main(String[] args) {
        numbers(5);
    }

//    public static void number(int data){    //1
//        if (data==0) return;
//        System.out.println(data);  // 5
//        number(data-1){     //2
//            if (data==0) return;
//            System.out.println(data);  // 4
//            number(data-1){     //3
//                if (data==0) return;
//                System.out.println(data);  // 3
//                number(data-1){     //4
//                    if (data==0) return;
//                    System.out.println(data);  // 2
//                    number(data-1){     //5
//                        if (data==0) return;
//                        System.out.println(data);  // 1
//                        number(data-1){     //6
//                            if (data==0) return;
//                            //Code Ends
//                }
//            };
//        };
//    }
}
