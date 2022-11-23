/*
https://school.programmers.co.kr/learn/courses/30/lessons/42884
        탐욕법(Greedy)
        단속카메라
*/

package greed;

import java.util.Arrays;
import java.util.Comparator;

public class SpeedTrap {

    public int solution(int[][] routes) {

        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(a->a[1]));

        for (int i = 0; i < routes.length; i++) {
            answer++;
            int firstEnd = routes[i][1];
            for (int j = i+1; j < routes.length; j++) {
                int nextStart = routes[j][0];
                if(nextStart > firstEnd){
                    break;
                }
                i++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SpeedTrap speedTrap = new SpeedTrap();
        int[][] routes ={{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
        int solution = speedTrap.solution(routes);
        System.out.println(solution);
    }
}
