/*
https://school.programmers.co.kr/learn/courses/30/lessons/152996
        연습문제
        시소 짝꿍
*/


package notSolved;


public class SeesawPartner {
    public long solution(int[] weights) {
        long answer = 0;

        for (int i = 0; i < weights.length - 1; i++) {
            for (int j = i + 1; j < weights.length; j++) {
                int target1 = weights[i];
                int target2 = weights[j];
                boolean flag = false;

                for (int k = 2; k <= 4; k++) {
                    if(flag){
                        continue;
                    }
                    for (int l = 2; l <= 4; l++) {
                        if(target1 * k == target2 * l){
                            answer++;
                            flag = true;
                        }
                    }
                }
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        SeesawPartner seesawPartner = new SeesawPartner();
        int[] weights = {100, 180, 360, 100, 270};
        long solution = seesawPartner.solution(weights);
        System.out.println("solution = " + solution);
    }
}
