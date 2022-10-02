package testpackage;

import java.util.ArrayList;
import java.util.HashMap;

public class Brans {

    ArrayList<Character> ruleWord = new ArrayList<>();
    HashMap<Character, ArrayList<Integer>> ruleMap = new HashMap<>();
    HashMap<Character, Integer> checkRule = new HashMap<>();

    public String solution(String sentence) {
        String answer = "";

        findRule(sentence);

        findRuleNum(sentence);

        for (Integer value : checkRule.values()) {
            if(value==0){
                return "invalid";
            }
        }
        StringBuilder answerSB = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentence.length(); i++) {
            char targetChar= sentence.charAt(i);
            //소문자 일때
            if(ruleWord.contains(targetChar)){

                //룰 2, 3일때
                if(checkRule.get(targetChar)==2 || checkRule.get(targetChar)==3){
                    if(sb.length() != 0){
                        sb.append(" ");
                    }
                    ArrayList<Integer> idxList = ruleMap.get(targetChar);
                    String substring1 = sentence.substring(idxList.get(0)+1, idxList.get(1));
                    String substring2 = substring1.replaceAll("[a-z]", "");
                    int dif = substring1.length() - substring2.length();
                    if(dif == 0 || dif == substring1.length()/2 ){
                        sb.append(substring2).append(" ");
                        answerSB.append(sb.toString());
                        sb = new StringBuilder();
                        i = idxList.get(1);
                    }else{
                        return "invalid";
                    }
                } else {
                    //룰 1일때
                    if(sb.length() == 0){
                        return "invalid";
                    }
                    ArrayList<Integer> idxList = ruleMap.get(targetChar);
                    String substring1 = sentence.substring(idxList.get(0), idxList.get(idxList.size()-1)+2);
                    String substring2 = substring1.replaceAll(targetChar+"", "");
                    int dif = substring1.length() - substring2.length();
                    if(dif == 0 || dif == substring1.length()/2 ){
                        sb.append(substring2).append(" ");
                        answerSB.append(sb.toString());
                        sb = new StringBuilder();
                        i = idxList.get(idxList.size()-1)+1;
                    }else{
                        return "invalid";
                    }
                }


            }else {
                if(sb.length() != 0){
                    sb.append(" ");
                }
                //대문자 일때
                sb.append(targetChar);
            }

        }
        answerSB.append(sb);

        return answerSB.toString().trim().replace("[ ]{1,}"," ");
    }

    private void findRule(String sentence) {

        for (int i = 0; i < sentence.length(); i++) {

            char targetChar = sentence.charAt(i);
            if(targetChar < 'a'){
                continue;
            }
            if(!ruleWord.contains(targetChar)){
                ruleWord.add(targetChar);
                ruleMap.put(targetChar,new ArrayList<>());
                ruleMap.get(targetChar).add(i);
            }else{
                ruleMap.get(targetChar).add(i);
            }

        }
    }

    private void findRuleNum(String sentence) {
        for (Character character : ruleWord) {
            ArrayList<Integer> ruleList = ruleMap.get(character);
            checkRule.put(character, 0);
            if(ruleList.size() == 2){
                checkRule.put(character, checkRule.get(character)+2);
            }
            boolean flag = true;
            for (int i = 1; i < ruleList.size(); i++) {
                 if(ruleList.get(i) - ruleList.get(i-1) != 2 ){
                    flag = false;
                 }
            }
            if(flag){
                checkRule.put(character, checkRule.get(character) + 1);
            }

            if(checkRule.get(character)==1){
                if(ruleList.get(0) == 0 || ruleList.get(ruleList.size()-1) == sentence.length()-1){
                    checkRule.put(character, 0);
                }
            }
        }
    }

    public static void main(String[] args) {
        Brans brans = new Brans();
        String test = brans.solution("HaEaLaLaObWORLDb");
        System.out.println("test = " + test);
        String sample = "012345";
        System.out.println("sample = " + sample.substring(0,6));
    }
}
