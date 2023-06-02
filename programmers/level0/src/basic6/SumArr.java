package basic6;

import java.util.stream.IntStream;

public class SumArr {
    public int solution(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).filter(i -> included[i]).map(i -> a + d * i).sum();
    }
}
