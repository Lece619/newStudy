//https://programmers.co.kr/learn/courses/30/lessons/67257?language=java
//코딩테스트 연습 2020 카카오 인턴십 수식 최대화

package kakao2020;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxExpression {

    static String[] priority;
    static long max;
    static LinkedList<String> list;

    public long solution(String expression) {
        priority= new String[]{"+-*", "+*-", "-*+", "-+*", "*+-", "*-+"};
        max = 0;
        String[] nums = expression.split("[-+*]");
        String[] express = expression.replaceAll("[0-9]","").split("");
        long answer = 0;
        list = new LinkedList<>();
        list.add(nums[0]);
        for (int i = 0; i < nums.length-1; i++) {
            list.add(express[i]);
            list.add(nums[i+1]);
        }
        for (String ex : priority) {
            calNum(ex);
        }
        return max;
    }

    public void calNum(String express){
        LinkedList<String> tempList = (LinkedList<String>) list.clone();
        for (int i = 0; i < express.length(); i++) {
            int idx=0;
            String command =express.charAt(i)+"";
            while((idx=tempList.indexOf(command))!=-1){
                //계산.
                String str = calWith(tempList.get(idx-1),command,tempList.get(idx+1));
                tempList.remove(idx-1);
                tempList.remove(idx-1);
                tempList.remove(idx-1);
                tempList.add(idx-1,str);
            }
        }
        max = Math.max(max,Math.abs(Long.parseLong(tempList.get(0))));
    }

    public String calWith(String n1,String command ,String n2){
        long num1 = Long.parseLong(n1);
        long num2 = Long.parseLong(n2);
        switch (command) {
            case "+":
                return (num1+num2)+"";

            case "*":
                return (num1 *num2)+"";

            case "-":
                return (num1-num2)+"";
        }
        return null;
    }


    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        new MaxExpression().solution(expression);
        System.out.println(max);
    }
}
