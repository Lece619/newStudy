/*
*
$   이항계수(n  m)$의 끝자리 $0$의 개수를 출력하는 프로그램을 작성하시오.
*
*    input 25 12           output 2
* */
import java.util.Scanner;
public class Num2004 {
// 10! 의 소인수 분해 했을 때 2 의 갯수를 생각
    public static long find2(long num){
        long cnt=0;
        while(num>=2){
            cnt+=num/2;
            num/=2;
        }
        return cnt;
    }
    public static long find5(long num){
        long cnt=0;
        while(num>=5){
            cnt+=num/5;
            num/=5;
        }
        return cnt;
    }
    public static void main(String[] args) {
        long num2=0;
        long num5=0;
        //combination C(n,k)  = n!/k!(n-k)!
        Scanner sc =new Scanner(System.in);
        long n=sc.nextLong();
        long k=sc.nextLong();
        num2=find2(n)-find2(k)-find2(n-k);
        num5=find5(n)-find5(k)-find5(n-k);
        System.out.println(Math.min(num2,num5));
    }

}
