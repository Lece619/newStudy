package basic7;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemainString {
    public String solution(int q, int r, String code) {
        return IntStream.range(0,code.length())
                .filter(i -> i % q == r)
                .mapToObj(i->String.valueOf(code.charAt(i)))
                .collect(Collectors.joining());
    }
}
