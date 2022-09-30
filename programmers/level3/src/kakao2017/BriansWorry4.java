/*
https://school.programmers.co.kr/learn/courses/30/lessons/1830
        2017 카카오코드 예선
        브라이언의 고민
*/

package kakao2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BriansWorry4 {

    ArrayList<Character> ruleWord = new ArrayList<>();
    HashMap<Character, ArrayList<Integer>> ruleIndex = new HashMap<>();

    public String solution(String sentence) {

        //공백 확인
        if(sentence.contains(" ")){
            return "invalid";
        }

        findRuleWord(sentence);

        return "";
    }

    private void findRuleWord(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char oneChar = sentence.charAt(i);
            if(oneChar >= 'a'){
                System.out.println("oneChar = " + oneChar);
                if(!ruleIndex.containsKey(oneChar)){
                    ruleWord.add(oneChar);
                    ruleIndex.put(oneChar, new ArrayList<>());
                }
                ruleIndex.get(oneChar).add(i);
            }
        }
    }


    public static void main(String[] args) {
        String sentence = "HaEaLaLaObWORLDb";
//        sentence = "SpIpGpOpNpGJqOqA";
//        sentence = "xAaAbAaAx";
        BriansWorry4 briansWorry = new BriansWorry4();
        System.out.println("briansWorry.solution(sentence) = " + briansWorry.solution(sentence));
    }
}
