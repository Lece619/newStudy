//https://programmers.co.kr/learn/courses/30/lessons/42885?language=java
//코딩테스트 연습
//탐욕법(Greedy)
//구명보트

package normal;

import java.util.Arrays;
import java.util.Comparator;

public class LifeBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        boolean[] life = new boolean[people.length];

        Arrays.sort(people);
        /*if(people[0]*2>limit){
            return people.length;
        }*/
        int startIndex = 0;
        int endIndex = people.length-1;
        while(startIndex<=endIndex){
            answer++;
            if( people[startIndex] + people[endIndex] <= limit)
                startIndex++;
            endIndex--;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] people = {70, 80, 50};
        new LifeBoat().solution(people,100);
    }
}
