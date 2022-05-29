//https://programmers.co.kr/learn/courses/30/lessons/12945 피보나치
package normal;

public class Fibonacci {
    static int[] fiboList;
    public int solution(int n) {
        fiboList=new int[n+1];
        fiboList[0]=0;
        fiboList[1]=1;
        int answer = fibo(n);
        System.out.println(answer);
        return answer;
    }
    public static int fibo(int n ){
        if(fiboList[n]!=0){
            return fiboList[n];
        }
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fiboList[n]=(fibo(n-1)+fibo(n-2))%1234567;
    }

    public static void main(String[] args) {
        new Fibonacci().solution(5);
    }
}
