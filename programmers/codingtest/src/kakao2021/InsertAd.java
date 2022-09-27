/*
https://school.programmers.co.kr/learn/courses/30/lessons/72414
        2021 KAKAO BLIND RECRUITMENT
        광고 삽입
*/

package kakao2021;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class InsertAd {

    HashMap<Integer, String> adPlayMap = new HashMap<>();
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        Arrays.sort(logs);
        for (String log : logs) {
            String[] logArr = log.split("-");
            makePlayTime(logArr, logs, adv_time);
        }
        makePlayTime(new String[]{"00:00:00","00:00:00"}, logs, adv_time);

        Integer max = Collections.max(adPlayMap.keySet());

        return adPlayMap.get(max);
    }

    private void makePlayTime(String[] logArr, String[] logs, String adv_time) {
        int start = makeSec(logArr[0]);
        int end = makeSec(logArr[1]);
        int endAdTime = start + makeSec(adv_time);
        int totalPlay = 0;

        for (String log : logs) {

            String[] checkLog = log.split("-");
            int logStart = makeSec(checkLog[0]);
            int logEnd = makeSec(checkLog[1]);

            if(logStart >= endAdTime){
                break;
            }

            int adTimeStart = Math.max(start, logStart);
            int adTimeEnd = Math.min(endAdTime, logEnd);
            if((adTimeEnd - adTimeStart) > 0) {
                totalPlay += adTimeEnd - adTimeStart;
            }
        }

        adPlayMap.put(totalPlay, findFastTime(adPlayMap.getOrDefault(totalPlay, "99:59:59"), logArr[0]));

    }

    private String findFastTime(String s1, String s2) {

        return s1.compareTo(s2) >= 0 ? s2 : s1;
    }

    private int makeSec(String time){
        String[] timeString = time.split(":");
        return Integer.parseInt(timeString[0]) * 60 * 60
                + Integer.parseInt(timeString[1]) * 60
                + Integer.parseInt(timeString[2]);
    }

    public static void main(String[] args) {
        InsertAd insertAd = new InsertAd();
        String play_time = "99:59:59";
        String adv_time = "25:00:00";
        String[] logs = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};
        String answer = insertAd.solution(play_time, adv_time, logs);
        System.out.println("answer = " + answer);
    }
}
