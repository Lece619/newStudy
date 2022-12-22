/*
https://school.programmers.co.kr/learn/courses/30/lessons/147355
        연습문제
        크기가 작은 부분 문자열
*/

package normal2;

public class SmallSubStringValue {
    public int solution(String t, String p) {

        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            sb.append(t.charAt(i));
        }

        long standard = Long.parseLong(p);
        answer += getAnswer(sb, standard);

        for (int i = p.length(); i < t.length(); i++) {
            sb.deleteCharAt(0).append(t.charAt(i));
            answer += getAnswer(sb, standard);
        }

        return answer;
    }

    private int getAnswer(StringBuilder sb, long standard) {
        if (Long.parseLong(sb.toString()) <= standard) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        SmallSubStringValue smallSubStringValue = new SmallSubStringValue();
        int solution = smallSubStringValue.solution("500220839878", "7");
        System.out.println(solution);
    }
}
