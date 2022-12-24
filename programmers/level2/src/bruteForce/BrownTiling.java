/*
https://school.programmers.co.kr/learn/courses/30/lessons/42842
        완전탐색
        카펫
*/

package bruteForce;

public class BrownTiling {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int area = brown + yellow;

        for (int i = (int)Math.sqrt(area); i > 0 ; i--) {
            if( area % i != 0){
                continue;
            }
            if( (i - 2) * (area / i - 2) == yellow){
                answer[0] = area / i;
                answer[1] = i;
                break;
            }
        }

        return answer;
    }
}
