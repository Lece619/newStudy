package basic7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class JoiningString {
    public String solution(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }
}
