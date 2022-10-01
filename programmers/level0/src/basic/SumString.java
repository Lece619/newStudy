package basic;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumString {
    public int solution(int n) {
        int answer = 0;
        int sum = (n + "").chars().mapToObj(c -> (char) c).mapToInt(c -> Character.digit(c, 10)).sum();
        System.out.println("intStream = " + sum);
        return answer;
    }

    public static void main(String[] args) {
        new SumString().solution(312321);
    }

}
