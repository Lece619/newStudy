/*
https://school.programmers.co.kr/learn/courses/30/lessons/17676
        2018 KAKAO BLIND RECRUITMENT
        [1차] 추석 트래픽
*/

package kakao2018;

import java.util.*;
import java.util.stream.Collectors;

public class TrafficOfThanksGiving {


    Queue<Long> timeLog = new LinkedList<>();

    public int solution(String[] lines) {
        int answer = 0;

        List<Log> list = Arrays.stream(lines).map(i -> new Log(i)).sorted(new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return (int) (o1.start - o2.start);
            }
        }).collect(Collectors.toList());

        ArrayList<Log> running = new ArrayList<>();

        for (Log log : list) {
            long start = log.start;
            long logCheck = start + 999;

            running.add(log);

            running = makeRunning(start, logCheck, running);

            answer = Math.max(answer, running.size());

            long end = log.end;
            logCheck = end + 999;

            running = makeRunning(end, logCheck, running);
            answer = Math.max(answer, running.size());

        }

        return answer;
    }

    private ArrayList<Log> makeRunning(long start, long logCheck, ArrayList<Log> running) {

        List<Log> result = running.stream().filter(log -> !(log.start > logCheck || log.end < start)).collect(Collectors.toList());

        return (ArrayList<Log>) result;
    }

    static class Log {
        long start;
        long end;
        String toString;
        @Override
        public String toString() {
            return toString;
        }

        public Log(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public Log(String log) {
            this.toString = log;
            String[] split = log.split(" ");
            String[] endTimeSplit = split[1].split("[:|\\.]");
            long running = 0;
            if(split[2].length() == 2){
                running = Long.parseLong(String.valueOf(split[2].charAt(0))) * 1000 - 1 ;
            }else {
                String[] runningTime = split[2].split("[s|\\.]");
                running = Long.parseLong(runningTime[0]) * 1000 + Long.parseLong(runningTime[1]) - 1;
            }

            this.end = Long.parseLong(endTimeSplit[0]) * 60 * 60 * 1000
                    + Long.parseLong(endTimeSplit[1]) * 60 * 1000
                    + Long.parseLong(endTimeSplit[2]) * 1000
                    + Long.parseLong(endTimeSplit[3]);

            this.start = end - running;

        }

    }

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        TrafficOfThanksGiving trafficOfThanksGiving = new TrafficOfThanksGiving();
        int solution = trafficOfThanksGiving.solution(lines);
        System.out.println("solution = " + solution);
    }
}
