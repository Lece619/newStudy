/*
https://school.programmers.co.kr/learn/courses/30/lessons/72414
        2021 KAKAO BLIND RECRUITMENT
        광고 삽입
*/

package kakao2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InsertAd2 {

    ArrayList<String> logList = new ArrayList<>();
    HashMap<Integer, String> adPlayMap = new HashMap<>();

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "00:00:00";
        int maxTotal = 0;
        int runningTime = makeTimeToSec(adv_time);

        Collections.addAll(logList, logs);
        Collections.sort(logList);
        int playTime = makeTimeToSec(play_time);

        for (int i = 0; i < logList.size(); i++) {
            int advEndTime = makeEndTime(logList.get(i), runningTime);

            if(advEndTime > playTime){
                break;
            }

            int advStartTime = advEndTime - runningTime;
            int totalRunningTime = 0;

            for (int j = 0; j < logList.size(); j++) {
                String[] s = logList.get(j).split("-");
                int startTime = makeTimeToSec(s[0]);
                int endTime = makeTimeToSec(s[1]);
                if (startTime >= advEndTime) {
                    break;
                }
                if(endTime <= advStartTime) {
                    continue;
                }
                totalRunningTime += Math.min(endTime,advEndTime) - Math.max(startTime, advStartTime);
//                System.out.println("Math.min(endTime,advEndTime) = " + Math.min(endTime,advEndTime));
//                System.out.println("Math.max(startTime, advStartTime) = " + Math.max(startTime, advStartTime));
            }

            if(maxTotal < totalRunningTime){
                maxTotal = totalRunningTime;
                answer = logList.get(i).split("-")[0];
            }
        }

        return answer;
    }

    private int makeTimeToSec(String time) {
        String[] timeSet = time.split(":");
        int hour = Integer.parseInt(timeSet[0]);
        int min = Integer.parseInt(timeSet[1]);
        int sec = Integer.parseInt(timeSet[2]);
        return hour * 60 * 60 + min * 60 + sec;
    }

    private int makeEndTime(String logTime, int runningTime) {
        String startTime = logTime.split("-")[0];
        return runningTime + makeTimeToSec(startTime);
    }


    public static void main(String[] args) {
        InsertAd2 insertAd = new InsertAd2();
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String answer = insertAd.solution(play_time, adv_time, logs);
        System.out.println("answer = " + answer);
    }
}
