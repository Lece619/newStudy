package basic8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountAmongX {
    public int[] solution(String myString) {
        List<Integer> list = Arrays.stream(myString.split("x")).mapToInt(String::length).boxed().collect(Collectors.toList());
        if(myString.endsWith("x"))
            list.add(0);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
