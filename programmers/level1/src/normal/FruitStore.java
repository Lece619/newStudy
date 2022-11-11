package normal;

import java.util.Arrays;
import java.util.Comparator;

public class FruitStore {

    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int idx = 0;

        int[] sortedScore = Arrays.stream(score).boxed()
                .sorted(Comparator.reverseOrder()).mapToInt(i -> i).toArray();

        for (int i = 0; i < sortedScore.length; i++) {
            idx++;
            if(idx % m == 0){
                answer += m * sortedScore[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        FruitStore fruitStore = new FruitStore();
        int solution = fruitStore.solution(k, m, score);
        System.out.println("solution = " + solution);
    }
}
