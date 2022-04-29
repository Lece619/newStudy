/*
*
$   이항계수(n  m)$의 끝자리 $0$의 개수를 출력하는 프로그램을 작성하시오.
*
*    input 25 12           output 2
* */
import java.util.Scanner;
//시간초과
public class Num2004 {
    public static void main(String[] args) {
        int num2=0;
        int num5=0;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        for(int i=n-k+1;i<=n;i++){
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
        for(int i=1;i<=k;i++){
            int num=i;
            while(true){
                if(num%2==0){
                    num/=2;
                    num2--;
                    continue;
                }
                if(num%5==0){
                    num/=5;
                    num5--;
                    continue;
                }
                break;
            }
        }
        if(num2>num5) System.out.println(num5);
        else System.out.println(num2);
    }
}
