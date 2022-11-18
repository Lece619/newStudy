/*
https://school.programmers.co.kr/learn/courses/30/lessons/42626
        힙(Heap)
        더 맵게
*/

package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class MoreSpicy {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovilles = Arrays.stream(scoville).boxed().collect(Collectors.toCollection(PriorityQueue::new));
        while(scovilles.peek() < K && scovilles.size() >= 2){
            answer++;
            Integer first = scovilles.poll();
            Integer second = scovilles.poll();

            scovilles.add(first + second * 2);
        }

        if(scovilles.peek() < K){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int k = 7;
        MoreSpicy moreSpicy = new MoreSpicy();
        int solution = moreSpicy.solution(scoville, k);
        System.out.println("solution = " + solution);
    }
}
