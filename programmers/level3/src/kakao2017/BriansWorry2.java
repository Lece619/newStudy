/*
https://school.programmers.co.kr/learn/courses/30/lessons/1830
        2017 카카오코드 예선
        브라이언의 고민
*/

package kakao2017;

import java.util.HashMap;

public class BriansWorry2 {

    HashMap<Character, Integer> numRule = new HashMap<>();
    StringBuilder sb = new StringBuilder();
    public String solution(String sentence) {
        sentence += " ";

        makeNumChar(sentence);
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            System.out.println("c = " + c);
            System.out.println("i = " + i);
            if(c >= 'a'){
                if(numRule.get(c) == 2){
                    //rule2
                    int lastIdx = sentence.lastIndexOf(c);
                    sentence = sentence.replaceAll(c+""," ");
                    char rule1char = ' ';
                    for (int j = i + 1; j < lastIdx; j++) {

                        if(rule1char >= 'a'){
                            rule1char = sentence.charAt(j);
                            if(j==i+1){
                                return "invalid";
                            }
                            numRule.put(rule1char,numRule.get(rule1char)-1);
                        }
                    }
                    String substring = sentence.substring(i, lastIdx + 1);
                    System.out.println("substring = " + substring);
                    if(rule1char!=' '){
                        substring = substring.replaceAll(rule1char+"","");
                    }
                    System.out.println("substring = " + substring);
                    numRule.put(c,0);
                    sb.append(substring);
                    i = lastIdx;
                }else{
                    int lastIdx = sentence.lastIndexOf(c);
                    String substring = sentence.substring(i - 1, lastIdx + 2);

                    for (int j = i-1; j < lastIdx+2; j++) {
                        char c2 = sentence.charAt(j);
                        if(c2 >= 'a' && c2 != c ){
                           return "invalid";
                        }
                    }
                    substring = substring.replaceAll(c+"", "");
                    sb.append(substring).append(" ");
                    numRule.put(c,0);
                    i = lastIdx+1;
                }
            }
        }

        return sb.toString().replaceAll("[ ]+", " ").trim();
    }

    private void makeNumChar(String sentence) {
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c >= 'a'){
                numRule.put(c, numRule.getOrDefault(c, 0) + 1);
            }
        }
    }


    public static void main(String[] args) {
        String sentence = "HaEaLaLaObWORLDb";
        BriansWorry2 briansWorry = new BriansWorry2();
        System.out.println("briansWorry.solution(sentence) = " + briansWorry.solution(sentence));
    }
}
