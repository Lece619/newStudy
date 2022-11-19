package basic3;

import java.util.Arrays;

public class findElementLen {
    public int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(i -> i.length()).toArray();
    }
}
