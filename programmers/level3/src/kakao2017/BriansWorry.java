/*
https://school.programmers.co.kr/learn/courses/30/lessons/1830
        2017 카카오코드 예선
        브라이언의 고민
*/

package kakao2017;

import java.util.ArrayList;
import java.util.HashMap;

public class BriansWorry {

    ArrayList<Character> keys = new ArrayList<>();
    boolean isInvalid = false;
    HashMap<Character, ArrayList<Integer>> smallWord = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    int idx = -1;
    public String solution(String sentence) {
        String answer = "";

        boolean checkRule = true;

        for (int i = 0; i < sentence.length(); i++) {
             char key = sentence.charAt(i);

             if(key==' '){
                 return "invalid";
             }

             if(key<'a'){
                 continue;
             }

             if(!smallWord.containsKey(key)){
                 smallWord.put(key,new ArrayList<>());
                 keys.add(key);
             }
             smallWord.get(key).add(i);
             checkRule = false;


        }

        if(checkRule){
            return sentence;
        }
        makeResult(sentence);

        return isInvalid ? "invalid" : sb.toString().replaceAll("  ", " ").trim();
    }

    private void makeResult(String sentence) {

        boolean checkRuleOne = true;
        boolean checkRuleTwo = false;

        for (Character character : keys) {
            int now = -1;
            ArrayList<Integer> checkArray = smallWord.get(character);
            for (Integer idx: checkArray) {
                if(now == -1){
                    now = idx - 2;
                }

                if(now == (idx - 2) ){
                    now = idx;
                }else{
                    checkRuleOne = false;
                }
            }

            if(!checkRuleOne){
                if(checkArray.size()==2){
                    checkRuleTwo = true;
                }
            }

            if(checkRuleOne){
                makeWordRuleOne(checkArray, sentence);
            }else if(checkRuleTwo){
                makeWordRuleTwo(checkArray, sentence);
                checkRuleOne = true;
                checkRuleTwo = false;
            }else{
                isInvalid = true;
                break;
            }

            if(isInvalid){
                break;
            }
        }
    }

    private void makeWordRuleOne(ArrayList<Integer> checkArray, String sentence) {
        StringBuilder tempSb = new StringBuilder();
        int now = 0;
        int start = checkArray.get(0) - 1;
        int end = checkArray.get(checkArray.size()-1) + 2;

        if(start <= idx || (end-1) == sentence.length()){
            isInvalid = true;
            return;
        }
        tempSb.append(" ");
        for (Integer integer : checkArray) {
            tempSb.append(sentence.charAt(integer - 1));
        }
        tempSb.append(sentence.charAt(end - 1)).append(" ");
        sb.append(tempSb);
        idx = end - 1;
    }

    private void makeWordRuleTwo(ArrayList<Integer> checkArray, String sentence) {
        StringBuilder tempSb = new StringBuilder();
        int start = checkArray.get(0);
        int end = checkArray.get(checkArray.size()-1);
        if(start < idx){
            isInvalid = true;
            return;
        }
        if(start == (idx + 2) ){
            tempSb.append(" ").append(sentence.charAt(idx+1)).append(" ");
        }
        tempSb.append(" ").append(sentence.substring(start+1, end)).append(" ");

        sb.append(tempSb);
        idx = end;
    }


    public static void main(String[] args) {
        String sentence = "bWORLDbHaEaLaLaOa";
        BriansWorry briansWorry = new BriansWorry();
        System.out.println("briansWorry.solution(sentence) = " + briansWorry.solution(sentence));
    }
}
