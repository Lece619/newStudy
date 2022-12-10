package inner;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int answer = 1;
        //여기에 코드를 써주세요.
        while(true){
            if(n % answer == 1){
                break;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
