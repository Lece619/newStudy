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
    ArrayList<Integer> smallWord = new ArrayList<>();
    HashMap<Character, Integer> ruleStyle = new HashMap<>();
    HashMap<Character, ArrayList<Integer>> ruleIndex = new HashMap<>();

    public String solution(String sentence) {

        //소문자 확인
        findRuleWord(sentence);

        //각각 소문자 룰 확인
        checkRuleByKey();

        //공백 확인
        if(sentence.contains(" ")){
            return "invalid";
        }

        //규칙이 배정 안된 글자가 있다면 X
        if(ruleStyle.containsValue(0)){
            return "invalid";
        }

        String answer = findAnswer(sentence);



        System.out.println("ruleWord = " + ruleWord);
        System.out.println("ruleIndex = " + ruleIndex);
        System.out.println("ruleStyle = " + ruleStyle);
        System.out.println("smallWord = " + smallWord);

        return "";
    }

    private void findRuleWord(String sentence) {

        for (int i = 0; i < sentence.length(); i++) {

            char oneChar = sentence.charAt(i);
            if(oneChar >= 'a'){
                if(!ruleIndex.containsKey(oneChar)){
                    ruleWord.add(oneChar);
                    ruleIndex.put(oneChar, new ArrayList<>());
                }
                ruleIndex.get(oneChar).add(i);
                smallWord.add(i);
            }
        }

    }

    private void checkRuleByKey() {

        for (Character character : ruleWord) {
            //규칙 1 확인
            checkRuleNum(character);
        }

    }

    private void checkRuleNum(Character character) {
        ArrayList<Integer> arrayList = ruleIndex.get(character);

        //rule2 확인
        if(arrayList.size() == 2 && arrayList.get(1) - arrayList.get(0) > 1) {
            ruleStyle.put(character, ruleStyle.getOrDefault(character, 0) + arrayList.size());
        }

        //rule1 확인
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i) - arrayList.get(i-1) != 2){
                return;
            }
        }

        ruleStyle.put(character, ruleStyle.getOrDefault(character, 0) + 1);
    }

    private String findAnswer(String sentence) {

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char nowChar = sentence.charAt(i);
            if(nowChar >= 'a') {

                if (ruleStyle.get(nowChar) == 2) {
                    Integer start = ruleIndex.get(nowChar).get(0);
                    Integer end = ruleIndex.get(nowChar).get(1);
                    char ruleOne = '-';
                    for (int j = start + 1; j < end; j++) {
                        char findOneThree = sentence.charAt(j);
                    }
                }
            }
        }
        
        return "invalid";
    }

    public static void main(String[] args) {
        String sentence = "HaEaLaLaObWORLDb";
//        sentence = "SpIpGpOpNpGJqOqA";
//        sentence = "xAaAbAaAx";
        BriansWorry4 briansWorry = new BriansWorry4();
        System.out.println("briansWorry.solution(sentence) = " + briansWorry.solution(sentence));
    }
}
