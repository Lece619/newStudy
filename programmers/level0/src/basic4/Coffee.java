package basic4;

import java.util.Arrays;

public class Coffee {
    public int solution(String[] order) {
        return Arrays.stream(order).mapToInt(i->i.contains("cafelatte") ? 5000 : 4500).sum();
    }
}
