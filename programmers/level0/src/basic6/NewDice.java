package basic6;

import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class NewDice {
    public int solution(int a, int b, int c) {
        return (int) IntStream.rangeClosed(1, 3 - new HashSet<>(List.of(a, b, c)).size())
                .mapToDouble(i -> Math.pow(a, i) + Math.pow(b, i) + Math.pow(c, i))
                .reduce(1, (i, j) -> i * j);
    }
}
