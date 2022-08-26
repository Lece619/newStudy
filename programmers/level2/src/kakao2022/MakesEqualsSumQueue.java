package kakao2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class MakesEqualsSumQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public int solution(int[] queue1, int[] queue2) {
        long total = 0 ;
        long sum = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            total += (queue1[i] + queue2[i]);
            sum += queue1[i];
        }
        if(total % 2 != 0){
            return -1;
        }else{
            total /= 2;
        }
        int answer = 0;

        for (int i = 0; i < queue1.length * 2; i++) {
            if(sum > total){
                while( sum > total){
                    int remove = q1.poll();
                    q2.add(remove);
                    sum -= remove;
                    answer++;
                }
            }else if( sum < total ){
                int remove = q2.poll();
                q1.add(remove);
                sum += remove;
                answer++;
            }

            if(sum == total){
                return answer;
            }

        }

        return -1;
    }
    public static void main(String[] args) {
        MakesEqualsSumQueue makesEqualsSumQueue = new MakesEqualsSumQueue();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};

        int solution = makesEqualsSumQueue.solution(queue1, queue2);
        System.out.println("solution = " + solution);
    }
}
