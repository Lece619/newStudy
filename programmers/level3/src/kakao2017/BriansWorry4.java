/*
https://school.programmers.co.kr/learn/courses/30/lessons/1830
        2017 카카오코드 예선
        브라이언의 고민
*/

package kakao2017;

import java.util.ArrayList;
import java.util.HashMap;

public class BriansWorry4 {

    ArrayList<Character> ruleWord = new ArrayList<>();
    ArrayList<Integer> smallWord = new ArrayList<>();
    HashMap<Character, Integer> ruleStyle = new HashMap<>();
    HashMap<Character, ArrayList<Integer>> ruleIndex = new HashMap<>();
    StringBuilder answerSB = new StringBuilder();

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

        boolean answerCheck = findAnswer(sentence);

        return answerCheck ? answerSB.toString().trim() : "invalid";
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
            //규칙 확인
            checkRuleNum(character);
        }

    }

    private void checkRuleNum(Character character) {
        ArrayList<Integer> arrayList = ruleIndex.get(character);
        ruleStyle.put(character, ruleStyle.getOrDefault(character, 0));
        //rule2 확인
        if(arrayList.size() == 2 && arrayList.get(1) - arrayList.get(0) > 1) {
            ruleStyle.put(character, ruleStyle.get(character) + arrayList.size());
        }

        //rule1 확인
        for (int i = 1; i < arrayList.size(); i++) {
            if(arrayList.get(i) - arrayList.get(i-1) != 2){
                return;
            }
        }

        ruleStyle.put(character, ruleStyle.get(character) + 1);
    }

    private boolean findAnswer(String sentence) {

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {

            char nowChar = sentence.charAt(i);

            if(nowChar >= 'a') {

                // 규칙 2일때
                ArrayList<Integer> ruleArr = ruleIndex.get(nowChar);
                Integer start = ruleArr.get(0);
                Integer end = ruleArr.get(ruleArr.size()-1);

                if (ruleStyle.get(nowChar) == 2) {
                    if(sb.length()!=0){
                        sb.append(" ");
                    }
                    char ruleOne = '-';
                    for (int j = start + 1; j < end; j++) {
                        char findOneThree = sentence.charAt(j);
                        if(ruleWord.contains(findOneThree)){
                            //규칙 2 내부에 2가 있을때
                            if(ruleStyle.get(findOneThree) == 2){
                                return false;
                            }
                            //규칙 2 내부에 1이 있을때
                            else{
                                if(ruleOne == '-'){
                                    ruleOne = findOneThree;
                                }else if(ruleOne != findOneThree){
                                    return false;
                                }else if(j==end-1||j==start+1){
                                    return false;
                                }
                            }
                        }else{
                            sb.append(findOneThree);
                        }
                    }
                    answerSB.append(sb).append(" ");
                    sb = new StringBuilder();
                    i = end;
                }
                //규칙 1일때
                else if(ruleStyle.get(nowChar) == 1){

                    if(sb.length()==0){
                        return false;
                    }
                    if(sb.length()!=1){
                        sb.insert(sb.length()-1,' ');
                    }

                    if(end == sentence.length()-1){
                        return false;
                    }
                    for (int j = start; j <= end; j++) {
                        char findErr = sentence.charAt(j);
                        if(findErr >= 'a'){
                            if(findErr != nowChar){
                                return false;
                            }
                        }else{
                            sb.append(findErr);
                        }
                    }
                    sb.append(sentence.charAt(end+1));
                    i = end+1;
                    answerSB.append(sb).append(" ");
                    sb = new StringBuilder();
                }else{ //규칙 3일 때
                    if(sb.length()!=0){
                        sb.append(" ");
                    }
                    sb.append(sentence.charAt(start+1)).append(" ");
                    answerSB.append(sb);
                    sb = new StringBuilder();
                    i = end;
                }

            }else{
                sb.append(nowChar);
            }

        }

        answerSB.append(sb);
        return true;
    }

    public static void main(String[] args) {
        String sentence = "cWxOxRxLxDcHaEaLaLaObWORLDb";
        sentence = "AbAaAbAaC";
//        sentence = "xAaAbAaAx";
        BriansWorry4 briansWorry = new BriansWorry4();
        System.out.println("briansWorry.solution(sentence) = " + briansWorry.solution(sentence));
    }
}
