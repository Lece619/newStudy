/*
https://school.programmers.co.kr/learn/courses/30/lessons/118666
        2022 KAKAO TECH INTERNSHIP
        성격 유형 검사하기
*/

package kakao2022;

public class FindPersonalityType {
    String find = "RTCFJMAN";
    String answer = "";
    public String solution(String[] survey, int[] choices) {

        int[] scores = new int[find.length()];
        for (int i = 0; i < survey.length; i++) {
            makeScore(survey[i], choices[i], scores);
        }
        for (int i = 0; i < scores.length; i+=2) {
            if(scores[i]<scores[i+1]){
                answer += find.charAt(i+1);
            }else{
                answer += find.charAt(i);
            }
        }
        return answer;
    }

    private void makeScore(String s, int choice, int[] scores) {
        int type = choice >= 4 ? 1 : 0;
        choice = Math.abs(choice-4);
        scores[find.indexOf(s.charAt(type))] += choice;
    }

    public static void main(String[] args) {
        FindPersonalityType findPersonalityType = new FindPersonalityType();
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String answer = findPersonalityType.solution(survey, choices);

        System.out.println("answer = " + answer);
    }
}
