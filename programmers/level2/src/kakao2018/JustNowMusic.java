/*
https://school.programmers.co.kr/learn/courses/30/lessons/17683
        2018 KAKAO BLIND RECRUITMENT
        [3차] 방금그곡
*/

package kakao2018;


public class JustNowMusic {

    int maxTime = 0;
    String answerMusic = "";

    public String solution(String m, String[] musicinfos) {

        makeMusicSets(musicinfos, m);

        return answerMusic.equals("") ? "(None)" : answerMusic;
    }

    private void makeMusicSets(String[] musicinfos, String m) {
        for (int i = musicinfos.length - 1; i >= 0; i-- ) {
            String[] music = musicinfos[i].split(",");
            String musicTitle = music[2];
            int playTime = makePlayTime(music);
            StringBuilder sb = new StringBuilder();
            String melody = removeSharp(music[3]);
            m = removeSharp(m);

            for (int j = 0; j < playTime; j++) {
                sb.append(melody.charAt(j % melody.length()));
            }
            if(sb.toString().contains(m) && playTime >= maxTime){
                maxTime = playTime;
                answerMusic = musicTitle;
            }
        }
    }

    private String removeSharp(String str) {
        return str.replaceAll("C#","0")
                .replaceAll("D#", "1")
                .replaceAll("F#", "1")
                .replaceAll("G#", "2")
                .replaceAll("A#", "3");
    }

    private int makePlayTime(String[] music) {
        String startTime = music[0];
        String endTime = music[1];
        return Integer.parseInt(endTime.substring(0, 2)) * 60
                + Integer.parseInt(endTime.substring(3))
                -( Integer.parseInt(startTime.substring(0, 2)) * 60
                + Integer.parseInt(startTime.substring(3)));
    }

    public static void main(String[] args) {
        JustNowMusic justNowMusic = new JustNowMusic();
        String m  ="ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println("justNowMusic.solution(m, musicinfos) = " + justNowMusic.solution(m, musicinfos));

        m = "ABC";
        String[] musicInfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println("justNowMusic.solution(m, musicInfos) = " + justNowMusic.solution(m, musicInfos));
    }
}
