/*
https://school.programmers.co.kr/learn/courses/30/lessons/133499
        연습문제
        옹알이 (2)
*/

package normal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Babbling {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        for (String checkWord : babbling) {

            for (int i = 0; i < word.length; i++) {
                checkWord = checkWord.replaceAll(word[i], i + "");
                checkWord = checkWord.replaceAll(i+""+i, "!");
            }
            if(checkWord.contains("!")){
                continue;
            }
            Pattern pattern = Pattern.compile("[a-zA-Z]");
            Matcher matcher = pattern.matcher(checkWord);
            if(matcher.find()){
                continue;
            }
            answer++;
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
