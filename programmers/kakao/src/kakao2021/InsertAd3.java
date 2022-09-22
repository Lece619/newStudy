/*
https://school.programmers.co.kr/learn/courses/30/lessons/72414
        2021 KAKAO BLIND RECRUITMENT
        광고 삽입
*/

package kakao2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class InsertAd3 {

    ArrayList<String> logList = new ArrayList<>();
    HashMap<Integer, String> adPlayMap = new HashMap<>();

    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "00:00:00";
        int maxTotal = 0;
        int runningTime = makeTimeToSec(adv_time);
        int playTime = makeTimeToSec(play_time);
        long[] viewTime = new long[playTime+1];

        for (int i = 0; i < logs.length; i++) {
            String[] s = logs[i].split("-");
            int startTime = makeTimeToSec(s[0]);
            int endTime = makeTimeToSec(s[1]);
            for (int j = startTime; j <= endTime; j++) {
                viewTime[j]++;
            }
        }

        for (long l : viewTime) {
            if(l==0){
                continue;
            }
            System.out.print(l+ " ");
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
        InsertAd3 insertAd = new InsertAd3();
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String answer = insertAd.solution(play_time, adv_time, logs);
        System.out.println("answer = " + answer);
    }
}
