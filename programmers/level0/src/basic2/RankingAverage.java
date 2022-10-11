package basic2;

import java.util.*;

public class RankingAverage {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        HashMap<Double, ArrayList<Integer>> scoreMap = new HashMap<>();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            int[] ints = score[i];
            double avg = (double)(ints[0] + ints[1]) / 2;

            if (!scoreMap.containsKey(avg)) {
                list.add(avg);
                scoreMap.put(avg, new ArrayList<>());
            }
            scoreMap.get(avg).add(i);
        }
        int idx = 1;
        Collections.sort(list,Collections.reverseOrder());
        for (Double average : list) {
            int count = 0;
            for (Integer integer1 : scoreMap.get(average)) {
                answer[integer1] = idx;
                count++;
            }
            idx+= count;
        }
        return answer;
    }

    public static void main(String[] args) {
        RankingAverage rankingAverage = new RankingAverage();
        int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
        int[] solution = rankingAverage.solution(score);
        for (int i : solution) {
            System.out.print(i + " ");
        }

    }
}
