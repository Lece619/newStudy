import java.util.Scanner;

public class Num11720 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        String numString=sc.next();
        int result=0;
        for(int i =0;i<num;i++){
            result+=Integer.parseInt(String.valueOf(numString.charAt(i)));
        }
        System.out.println(result);
    }
}
