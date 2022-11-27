/*
https://school.programmers.co.kr/learn/courses/30/lessons/133499
        연습문제
        옹알이 (2)
*/

package normal2;

import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Babbling {
    public int solution(String[] babbling) {

        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};

        for (String target : babbling) {
            for (int i = 0; i < word.length; i++) {
                target = target.replaceAll(word[i], String.valueOf(i));
                target = target.replaceAll(String.valueOf(i).repeat(2),"!");
            }
            if(target.contains("!")){
                continue;
            }
            Pattern pattern = Pattern.compile("[a-z|A-Z]");
            Matcher matcher = pattern.matcher(target);
            if(!matcher.find()) {
                answer++;
            }
        }

        List<String> word2 = List.of("aya", "ye", "woo", "ma");
        for (String target : babbling) {
            Stack<String> words = new Stack<>();
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while(idx < target.length()){
                sb.append(target.charAt(idx));
                idx++;
                if(word2.contains(sb.toString())){
                    if(!words.isEmpty() && words.peek().equals(sb.toString())) {
                        break;
                    }
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            if(sb.length()==0){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Babbling babbling = new Babbling();
        String[] babblingChat = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        int solution = babbling.solution(babblingChat);
        System.out.println("solution = " + solution);
    }

}
