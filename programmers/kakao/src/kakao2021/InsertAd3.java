/*
https://school.programmers.co.kr/learn/courses/30/lessons/72414
        2021 KAKAO BLIND RECRUITMENT
        광고 삽입
*/

package kakao2021;

public class InsertAd3 {

    public String solution(String play_time, String adv_time, String[] logs) {

        int runningTime = makeTimeToSec(adv_time);
        int playTime = makeTimeToSec(play_time);
        int[] viewTime = new int[playTime];
        for (int i = 0; i < logs.length; i++) {
            String[] s = logs[i].split("-");
            int startTime = makeTimeToSec(s[0]);
            int endTime = makeTimeToSec(s[1]);
            for (int j = startTime; j < endTime; j++) {
                viewTime[j]++;
            }
        }

        long totalSum = 0;
        long maxSum = 0;
        int time = 0;
        for (int i = 0; i < runningTime; i++) {
            totalSum += viewTime[i];
        }
        maxSum = totalSum;

        for (int i = runningTime; i < playTime; i++) {
            totalSum += viewTime[i] - viewTime[i-runningTime];
            if(maxSum < totalSum){
                maxSum = totalSum;
                time = i-runningTime+1;
            }

        }

        return makeTimeToString(time);
    }

    private int makeTimeToSec(String time) {
        String[] timeSet = time.split(":");
        int hour = Integer.parseInt(timeSet[0]);
        int min = Integer.parseInt(timeSet[1]);
        int sec = Integer.parseInt(timeSet[2]);
        return hour * 60 * 60 + min * 60 + sec;
    }

    private String makeTimeToString(int time){
        int hour = time/3600;
        int min = (time%3600)/60;
        int sec = (time%3600)%60;
        return String.format("%02d:%02d:%02d",hour, min, sec);
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
