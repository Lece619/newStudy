/*
https://school.programmers.co.kr/learn/courses/30/lessons/42885
        탐욕법(Greedy)
        구명보트
*/

package greedy;

import java.util.Arrays;

public class SafetyBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int start = 0;
        int end = people.length - 1;

        while(start <= end){
            answer++;

            if(people[start] + people[end] <= limit){
                start++;
            }
            end--;
        }

        return answer;
    }
}
