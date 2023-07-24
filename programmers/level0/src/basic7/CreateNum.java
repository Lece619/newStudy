package basic7;

import java.util.stream.IntStream;

public class CreateNum {
    public String[] solution(String[] names) {
        return IntStream.range(0, names.length).filter(i -> i % 5 == 0).mapToObj(i->names[i]).toArray(String[]::new);
    }
}
