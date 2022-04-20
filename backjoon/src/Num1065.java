import java.util.Scanner;

public class Num1065 {
    //한수인지 확인
    public static boolean hanNum(int num){
        if(num<100) return true;
        else{
            String numString=""+num;
            int lenNum=numString.length();
            int d=num%10-(num/10)%10;
            for(int i=0;i<lenNum-1;i++){
                if(d-(num%10-(num/10)%10)!=0){
                    return false;                }
                num/=10;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
        int result=0;
        for(int i=1;i<=num;i++){
            if(hanNum(i)) result++;
        }
        System.out.println(result);
    }
}
