/*
https://school.programmers.co.kr/learn/courses/30/lessons/131128
        연습문제
        숫자 짝꿍
*/

package normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class NumberCouple {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        ArrayList<Integer> charList = new ArrayList<>();
        for (int i = 0; i < X.length(); i++) {
            String ch = String.valueOf(X.charAt(i));
            if(Y.contains(ch+"")){
                charList.add(Integer.parseInt(ch));
                Y = Y.replaceFirst(ch,"");
            }
        }
        Collections.sort(charList,Collections.reverseOrder());
        for (Integer integer : charList) {
            answer.append(integer);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        NumberCouple numberCouple = new NumberCouple();
        String X = "5525";
        String Y = "1255";
        String solution = numberCouple.solution(X, Y);
        System.out.println("solution = " + solution);
    }
}
