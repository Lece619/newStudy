/*
https://school.programmers.co.kr/learn/courses/30/lessons/42586
        스택/큐
        기능개발
*/

package stackqueue;

import java.util.*;
import java.util.stream.Collectors;

public class UpgradeAbility {
    public int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> complete = new ArrayList<>();
        Queue<Integer> days = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            days.add(day);
        }

        while(!days.isEmpty()){
            Integer poll = days.poll();
            int count = 1;
            
            while(!days.isEmpty() && days.peek() <= poll){
                days.poll();
                count++;
            }
            complete.add(count);
        }

        return complete.stream().mapToInt(i -> (int) i).toArray();
    }

    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        UpgradeAbility upgradeAbility = new UpgradeAbility();
        int[] solution = upgradeAbility.solution(progresses, speeds);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
