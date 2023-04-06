/*
https://school.programmers.co.kr/learn/courses/30/lessons/176963
        연습문제
        추억 점수
*/

package normal2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MemoryScore {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scores = IntStream.range(0, name.length)
                .boxed()
                .collect(Collectors.toMap(i -> name[i], i -> yearning[i]));

        return Arrays.stream(photo).
                mapToInt(photoMembers -> Arrays.stream(photoMembers)
                        .filter(scores::containsKey)
                        .mapToInt(scores::get).sum()
                ).toArray();
    }

    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"brin", "brin", "brin", "deny"},{"kon", "kain", "may", "coni"}};

        MemoryScore memoryScore = new MemoryScore();
        int[] solution = memoryScore.solution(name, yearning, photo);
        for (int i : solution) {
            System.out.println(i);
        }

    }
}
