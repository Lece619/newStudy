/*
https://school.programmers.co.kr/learn/courses/30/lessons/150370
        2023 KAKAO BLIND RECRUITMENT
        개인정보 수집 유효기간
*/

package kakao2023;

public class PrivateInfoTerm {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
//        28일 모든 달
        
        return answer;
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        PrivateInfoTerm privateInfoTerm = new PrivateInfoTerm();
        int[] solution = privateInfoTerm.solution(today, terms, privacies);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
