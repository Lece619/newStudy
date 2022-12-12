package basic4;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamTest {
    public int solution(int n) {
        return IntStream.rangeClosed(1,n).filter(i->i%2==0).sum();
    }
    public String solution(String my_string, int n) {
        return my_string.chars().mapToObj(i->{return String.valueOf((char)i).repeat(3);}).collect(Collectors.joining());
    }
    /*
    map >> ??
    python
     */
}
