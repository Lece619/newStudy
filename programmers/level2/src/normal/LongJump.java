/*
https://school.programmers.co.kr/learn/courses/30/lessons/12914
        연습문제
        멀리 뛰기
*/
package normal;

public class LongJump {

    public long solution(int n) {
        int mod = 1234567;
        long a = 1;
        long b = 1;

        for (int i = 1; i < n; i++) {
            long c = (a + b) % mod;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        LongJump longJump = new LongJump();
        System.out.println("longJump.solution(4) = " + longJump.solution(4));
    }
}
