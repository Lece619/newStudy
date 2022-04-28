/*
N!에서 뒤에서부터 처음 0이 아닌 숫자가
나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

input 10   output2
input 3    output0
 */

import java.util.Scanner;

public class Num1676 {
    public static void main(String[] args) {
        int num2=0;
        int num5=0;
        int N=new Scanner(System.in).nextInt();
        for(int i=1;i<=N;i++){
            int num=i;
            while(true){
                if(num%2==0){
                    num/=2;
                    num2++;
                    continue;
                }
                if(num%5==0){
                    num/=5;
                    num5++;
                    continue;
                }
                break;
            }
        }
        if(num2>num5) System.out.println(num5);
        else System.out.println(num2);
    }
}
