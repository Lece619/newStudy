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
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));


        while(count-- > 0){

            PriorityQueue<Job> nextJobTime = getJobs(jobs, done, time);
            Job nextJob = nextJobTime.peek();

            answer += nextJob.getNextTime(time);
            time = Math.max(time, nextJob.getStart()) + nextJob.getTerm();
            done[nextJob.getIdx()] = true;
            System.out.println("time = " + time);
        }
    
        return answer / jobs.length;
    }

    private PriorityQueue<Job> getJobs(int[][] jobs, boolean[] done, int time) {
        PriorityQueue<Job> nextJobTime = new PriorityQueue<>(new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.getNextTime(time) == o2.getNextTime(time)){
                    return o1.getStart() - o2.getStart();
                }
                return o1.getNextTime(time) - o2.getNextTime(time);
            }
        });

        for (int i = 0; i < jobs.length; i++) {
            int[] job = jobs[i];
            System.out.println("new Job(i, job[0], job[1]) = " + new Job(i, job[0], job[1]));
            if(time < job[0]){
                if(nextJobTime.isEmpty() && !done[i]){
                    nextJobTime.add(new Job(i, job[0], job[1]));
                    break;
                }
                break;
            }
            if(!done[i]) {
                nextJobTime.add(new Job(i, job[0], job[1]));
            }
        }
        System.out.println("nextJobTime = " + nextJobTime);
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

        public int getNextTime(int time){
            if(time >= start){
                return time - start + term;
            }
            return term;
        }

        public int getIdx() {
            return idx;
        }

        public int getStart() {
            return start;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "idx=" + idx +
                    ", start=" + start +
                    ", term=" + term +
                    '}';
        }
    }


    public static void main(String[] args) {
        int[][] jobs = {{0, 3},{0 , 4}, {0, 2},{1, 2}};
        DiskController diskController = new DiskController();
        int solution = diskController.solution(jobs);
        System.out.println("solution = " + solution);
    }
}
