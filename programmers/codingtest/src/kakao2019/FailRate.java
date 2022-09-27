/*
https://school.programmers.co.kr/learn/courses/30/lessons/42889
        2019 KAKAO BLIND RECRUITMENT
        실패율
*/
package kakao2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class FailRate {

    public int[] solution(int N, int[] stages) {
        int[] comStage = new int[N+2];
        int[] fail = new int[N+2];
        int[] answer = new int[N];

        for (int i : stages) {
            for (int j = 1; j <= i; j++) {
                comStage[j]++;
            }
            fail[i]++;
        }

        HashMap<Double, ArrayList<Integer>> rateMap = new HashMap<>();

        for (int i = 1; i < N+1; i++) {
            System.out.println("fail = " + fail[i]+ " / " + comStage[i]);
            double failRate=0;
            if(comStage[i]!=0){
                failRate = (double) fail[i] / comStage[i];
            }
            if(!rateMap.containsKey(failRate)){
                rateMap.put(failRate, new ArrayList<>());
            }
            rateMap.get(failRate).add(i);
        }

        ArrayList<Double> makeRateKey = new ArrayList<>(rateMap.keySet());
        Collections.sort(makeRateKey,Collections.reverseOrder());
        System.out.println("makeRateKey = " + makeRateKey);

        int idx = 0;
        for (Double key : makeRateKey) {
            for(Integer stage : rateMap.get(key)){
                answer[idx++] = stage;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int N = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

        FailRate failRate = new FailRate();
        int[] answer = failRate.solution(N, stages);

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
