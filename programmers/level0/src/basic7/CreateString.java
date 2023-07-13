package basic7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CreateString {
    public String solution(String my_string, int[] index_list) {
        return Arrays.stream(index_list).mapToObj(i->String.valueOf(my_string.charAt(i))).collect(Collectors.joining());
    }
}
