/*
https://school.programmers.co.kr/learn/courses/30/lessons/118667?language=java
        2022 KAKAO TECH INTERNSHIP
        두 큐 합 같게 만들기
*/

package kakao2022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MakesEqualsSum {
    int[] totalQueue;
    public int solution(int[] queue1, int[] queue2) {
        totalQueue = new int[queue1.length * 2];
        long target = makeTarget(queue1, queue2);

        if (target % 2 != 0) {
            return -1;
        } else {
            target /= 2;
        }


        Queue<Integer> queue = new LinkedList<>();
        long sumScore = 0;
        int answer2 = 0;
        boolean flag = false;
        for (int i = 0; i < totalQueue.length; i++) {

            if (totalQueue[i] > target) {
                return -1;
            }

            if (sumScore == target) {
                flag = true;
                break;
            } else if (sumScore > target) {
                while (sumScore > target) {
                    sumScore -= queue.poll();
                    answer2++;
                }
                if (sumScore == target) {
                    flag = true;
                    break;
                }
            }
            answer2++;
            queue.add(totalQueue[i]);
            sumScore += totalQueue[i];

        }
        answer2 = answer2 - totalQueue.length / 2 > 0 ? answer2 - totalQueue.length / 2 : totalQueue.length / 2 + answer2 ;

        return flag ? answer2 : -1;
    }

    private long makeTarget(int[] queue1, int[] queue2) {
        long target = 0;
        int index=0;
        for (int i : queue1) {
            totalQueue[index++] = i;
            target += i;
        }
        for (int i : queue2) {
            totalQueue[index++] = i;
            target += i;
        }
        return target;
    }

    public static void main(String[] args) {
        MakesEqualsSum makesEqualsSum = new MakesEqualsSum();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.println("makesEqualsSum.solution(queue1,queue2) = " + makesEqualsSum.solution(queue1, queue2));
        // 3 2 7 2 4 6 5 1
        // 3 [ 2 7 2 4 ] 6 5 1
        // 3 2 7 2 [ 4 6 5 ] 1
        // 3 2 7 [ 2 4 6 5 1 ]
        // 3 [ 2 7 ] 2 4 6 5 1  4 + 3  1  6  8 - 2
    }
}
