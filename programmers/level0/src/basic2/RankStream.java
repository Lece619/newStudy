package basic2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RankStream {
    public int[] solution(int[] emergency) {

        int[] answer = {};

        int[] ints = Arrays.stream(emergency)
                .map(i -> Arrays.stream(emergency)
                        .boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
                        .indexOf(i) + 1).toArray();
        for (int anInt : ints) {
            System.out.print(" " + anInt);
        }

        return answer;
    }

    public static void main(String[] args) {
        RankStream rankStream = new RankStream();
        rankStream.solution(new int[]{1, 2, 3, 4, 5, 6, 7});
    }
}
