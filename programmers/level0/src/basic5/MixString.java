package basic5;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MixString {
    public String solution(String str1, String str2) {

        return IntStream.range(0, str1.length())
                .mapToObj(i -> String.valueOf(str1.charAt(i)) + String.valueOf(str2.charAt(i)))
                .collect(Collectors.joining());
    }
}
