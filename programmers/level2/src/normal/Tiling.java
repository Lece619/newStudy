//https://school.programmers.co.kr/learn/courses/30/lessons/12900?language=java
//코딩테스트 연습  연습문제        2 x n 타일링
package normal;

public class Tiling {

    //점화식을 새울수 있다.
    //f(n)  = f(n-1) + f(n-2)
    //f(1) = 1 f(2) = 2
    public int solution(int n) {
        int a = 1;
        int b = 1;
        for (int i = 0; i < n-1; i++) {
            int c = (a + b) % 1_000_000_007;
            a = b;
            b = c;
        }

        return b;
    }
}
