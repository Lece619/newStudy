/*
https://school.programmers.co.kr/learn/courses/30/lessons/72414
        2021 KAKAO BLIND RECRUITMENT
        광고 삽입
*/

package kakao2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class InsertAd2 {

    ArrayList<String> logList = new ArrayList<>();
    HashMap<Integer, String> adPlayMap = new HashMap<>();

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int runningTime = makeTimeToSec(adv_time);
        System.out.println("runningTime = " + runningTime);

        Collections.addAll(logList, logs);
        Collections.sort(logList);


        for (int i = 0; i < logList.size(); i++) {
            String advEndTime = makeEndTime(logList.get(i), runningTime);
        }
        System.out.println("logList = " + logList);

        return answer;
    }

    private int makeTimeToSec(String time) {
        String[] timeSet = time.split(":");
        int hour = Integer.parseInt(timeSet[0]);
        int min = Integer.parseInt(timeSet[1]);
        int sec = Integer.parseInt(timeSet[2]);
        return hour * 60 * 60 + min * 60 + sec;
    }

    private String makeEndTime(String logTime, int runningTime) {
        String[] startTime = logTime.split("-")[0].split(":");
        return "";
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
