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
        boolean[] done = new boolean[jobs.length];
        int count = jobs.length;
        int time = 0;
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));


        while(count-- > 0){

            PriorityQueue<Job> nextJobTime = getJobs(jobs, done, time);
            Job nextJob = nextJobTime.poll();

            answer += nextJob.getTime(time);
            time = time + nextJob.getTerm() + Math.max(0, nextJob.getStart() - time);
            done[nextJob.getIdx()] = true;
        }
    
        return answer / jobs.length;
    }

    private PriorityQueue<Job> getJobs(int[][] jobs, boolean[] done, int time) {
        PriorityQueue<Job> nextJobTime = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o1.getTime(time) - o2.getTime(time);
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            if(time < job[0]){
                if(nextJobTime.isEmpty() && !done[i]){
                    nextJobTime.add(new Job(i, job[0], job[1]));
                    break;
                }
            }
            if(!done[i]) {
                nextJobTime.add(new Job(i, job[0], job[1]));
            }
        }
        return nextJobTime;
    }

    static class Job{
        int idx;
        int start;
        int term;

        public Job(int idx, int start, int term) {
            this.idx = idx;
            this.start = start;
            this.term = term;
        }

        public int getTerm() {
            return term;
        }

        public int getTime(int time){
            return Math.max(term,time + term - start);
        }

        public int getIdx() {
            return idx;
        }

        public int getStart() {
            return start;
        }
    }


    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        DiskController diskController = new DiskController();
        int solution = diskController.solution(jobs);
        System.out.println("solution = " + solution);

    }
}
