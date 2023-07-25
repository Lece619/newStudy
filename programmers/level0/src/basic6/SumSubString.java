package basic6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumSubString {
    public String solution(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length).mapToObj(i -> my_strings[i].substring(parts[i][0], parts[i][1])).collect(Collectors.joining());
    }
}