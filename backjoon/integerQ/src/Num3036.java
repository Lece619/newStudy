import java.util.Scanner;

public class Num3036 {

    static int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int[] rings=new int[n];
        for(int i =0;i<n;i++){
            rings[i]=sc.nextInt();
        }
        for(int i =1 ;i<n;i++){
            System.out.println(rings[0]/gcd(rings[0],rings[i])+"/"+rings[i]/gcd(rings[0],rings[i]));
        }
    }
}
