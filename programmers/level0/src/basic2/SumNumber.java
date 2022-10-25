package basic2;

import java.util.Arrays;

public class SumNumber {
    public int solution(String my_string) {
        int answer = 0;
        int sum = Arrays.stream(
                my_string.replaceAll("[^\\d]+", " ")
                        .trim()
                        .split(" "))
                .filter(s-> !s.equals(""))
                .mapToInt(Integer::parseInt).sum();
        System.out.println("sum = " + sum);
        return answer;
    }

    public static void main(String[] args) {
        SumNumber sumNumber = new SumNumber();
        sumNumber.solution("aaaaa");
    }
}
