package basic7;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemainString {
    public String solution(int q, int r, String code) {
        return IntStream.range(0,code.length())
                .filter(i -> i % q == r)
                .mapToObj(i->String.valueOf(code.charAt(i)))
                .collect(Collectors.joining());
    }
    public String[] solution(String my_string) {
    public String[] solution(String my_string) {
        List<String> collect = IntStream.range(0, my_string.length()).mapToObj(i -> my_string.substring(i)).collect(Collectors.toList());
        Collections.sort(collect);
        String[] answer = collect.toArray(new String[0]); 
        return answer;
    }
}
