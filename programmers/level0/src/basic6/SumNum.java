package basic6;

import java.util.Arrays;

public class SumNum {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for (int number : numbers) {
            answer += number;
            if( answer > n ){
                return answer;
            }
        }
        if(answer != 0){
            return Arrays.stream(numbers).reduce(0, (now, next) -> n > now ? now + next : now);
        }
        return answer;

    }

    public static void main(String[] args) {
        System.out.println(new SumNum().solution(new int[]{34, 5, 71, 29, 100, 34}, 123));
    }
}
