package inner;

import java.util.Scanner;

public class test1 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String answer = "";
        int num=in.nextInt();
        //여기에 코드를 써주세요.
        answer = num % 2 == 0 ? "Even" : "Odd";
        System.out.println(answer);
    }
}
