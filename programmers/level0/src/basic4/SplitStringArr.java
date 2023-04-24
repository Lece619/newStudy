package basic4;

import java.util.Arrays;

public class SplitStringArr {
    public String[] solution(String myString) {
        return Arrays.stream(myString.split("x")).filter(i->!i.isEmpty()).sorted().toArray(String[]::new);
    }
}
