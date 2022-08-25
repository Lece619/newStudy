/*
https://school.programmers.co.kr/learn/courses/30/lessons/118666?language=java
        코딩테스트 연습
        2022 KAKAO TECH INTERNSHIP
        성격 유형 검사하기
*/
package kakao2022;

import java.util.HashMap;

/*
* 1번 지표	라이언형(R), 튜브형(T)
2번 지표	콘형(C), 프로도형(F)
3번 지표	제이지형(J), 무지형(M)
4번 지표	어피치형(A), 네오형(N)
* */
public class SurveyChoice {

    HashMap<Character,Integer> scoreMap= new HashMap<>();

    public String solution(String[] survey, int[] choices) {
        String answer = "RTCFJMAN";
        makeScoreMap(survey, choices);

        System.out.println(scoreMap);
        return  removeChoice(answer);
    }

    private String removeChoice(String answer) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < answer.length(); i+=2) {
            if(scoreMap.getOrDefault(answer.charAt(i),0) < scoreMap.getOrDefault(answer.charAt(i+1),0) ){
                result.append(answer.charAt(i+1));
            }else{
                result.append(answer.charAt(i));
            }

        }
        return result.toString();
    }

    private void makeScoreMap(String[] survey, int[] choices) {
        for (int i = 0; i < survey.length; i++) {
            int score = choices[i] - 4 ;
            Character key;
            if (score > 0) {
                key = survey[i].charAt(1);
                scoreMap.put(key, scoreMap.getOrDefault(key, 0) + score);
                System.out.println("key = " + key);
            } else if (score < 0) {
                key = survey[i].charAt(0);
                scoreMap.put(key, scoreMap.getOrDefault(key, 0) + (score) * (-1) );
                System.out.println("key = " + key);

            }
        }
    }

    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};

        SurveyChoice test = new SurveyChoice();
        System.out.println("test.solution(survey,choices) = " + test.solution(survey, choices));
    }
}
