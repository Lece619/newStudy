package basic2;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Description {
    public String solution(String cipher, int code) {
        return IntStream.range(0, cipher.length())
                .filter(i -> (i + 1) % code == 0)
                .mapToObj(i -> String.valueOf(cipher.charAt(i)))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Description description = new Description();
        System.out.println("description.solution(\"dfjardstddetckdaccccdegk\",4) = " + description.solution("dfjardstddetckdaccccdegk", 4));
    }
}
