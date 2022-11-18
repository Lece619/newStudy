/*
https://school.programmers.co.kr/learn/courses/30/lessons/42627
        힙(Heap)
        디스크 컨트롤러
*/

package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DiskController {

    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        boolean[] done = new boolean[jobs.length];
        int time = 0;

        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            if(time < job[0]){
                break;
            }
        }

        return answer;
    }

    static class Job{

    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        DiskController diskController = new DiskController();
        int solution = diskController.solution(jobs);
        System.out.println("solution = " + solution);

    }
}
