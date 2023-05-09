package basic5;

import java.util.stream.IntStream;

public class MakeArr1 {

    public int[] solution(int n, int k) {
        return  IntStream.rangeClosed(1,n/k).map(i->i*k).toArray();
    }
}
