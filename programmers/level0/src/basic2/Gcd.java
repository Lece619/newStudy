/*
https://school.programmers.co.kr/learn/courses/30/lessons/120878
        코딩테스트 입문
        유한소수 판별하기
*/

//최대공약수 구해서 나누면 기약분수가 나온다.
package basic2;

public class Gcd {

    public int gcdCal(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcdCal(b, a % b);
        }
    }

    public int solution(int a, int b) {
        int gcd = gcdCal(a, b);
        System.out.println("gcd = " + gcd);
        int num = b / gcd;
        System.out.println("num = " + num);
        while(num%2==0){
            num/=2;
        }
        while(num%5==0){
            num/=5;
        }
        System.out.println("num = " + num);
        return num == 1 ? 1 : 2;
    }
}
