package basic3;

import java.util.stream.IntStream;

public class DividedNum {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if( n % i == 0 ){
                answer++;
            }
        }

        long count = IntStream.rangeClosed(1, n).filter(i -> i % n == 0).count();
        return answer;
    }
}
