//https://programmers.co.kr/learn/courses/30/lessons/67257?language=java
//코딩테스트 연습 2020 카카오 인턴십 수식 최대화

package kakao2020;

public class MaxExpression {

    public long solution(String expression) {
        String[] nums = expression.split("[-+*]");
        String express = expression.replaceAll("\\d","");
        long answer = 0;

        System.out.println(express);
        for (String num : nums) {
            System.out.print("  " + num);
        }
        return answer;
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        new MaxExpression().solution(expression);
    }
}
