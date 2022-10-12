/*
https://school.programmers.co.kr/learn/courses/30/lessons/131129
        연습문제
        카운트 다운
*/

package normal;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DartCount {
    public int[] solution(int target) {
        int[] answer = new int[2];
        int[] n = new int[61];

        Map<Integer, Integer> collect = IntStream.rangeClosed(0, 60).boxed().collect(Collectors.toMap(i -> i, i -> i <= 20 || i == 50 ? 1 : i % 3 == 0 ? 0 : 1));
        collect.put(0,0);

        for (int i = 1; i < 61; i++) {
            if(i <= 20 || i % 3 == 0 ){
                n[i] = 1;
            } else if (i<=40 && i % 2 == 0) {
                collect.put(i,1);
                n[i] = 1;
            } else{
                n[i] = 2;
            }
        }
        n[50] = 1;

        answer[0] += target/120 * 2;
        int targetSub = target % 120;

        int bull = targetSub / 50;
        int bullSub = targetSub % 50;
        bull += n[bullSub];
        bullSub = targetSub / 50 + collect.get(bullSub);

        int tri = targetSub / 60;
        int triSub = targetSub % 60;
        tri += n[triSub];
        triSub = collect.get(triSub);

        if(bull == tri){
            answer[0] += bull;
            answer[1] = Math.max(bullSub, triSub);
        }else if(bull < tri){
            answer[0] += bull;
            answer[1] = bullSub;
        }else{
            answer[0] += tri;
            answer[1] = triSub;
        }

        return answer;
    }

    public static void main(String[] args) {
        DartCount dartCount = new DartCount();
        System.out.println("dartCount.solution(21) = " + dartCount.solution(178));
    }

}
