package basic4;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFilter {
    public String solution(String my_string) {
//        my_string.replaceAll("[aeiou]",""); 같은결과
        List<Character> filterChars = List.of('a', 'e', 'i', 'o', 'u');
        return my_string.chars().mapToObj(i -> (char)i).filter(c -> !filterChars.contains(c)).map(String::valueOf).collect(Collectors.joining());
    }
}
