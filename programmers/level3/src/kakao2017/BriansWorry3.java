/*
https://school.programmers.co.kr/learn/courses/30/lessons/1830
        2017 카카오코드 예선
        브라이언의 고민
*/

package kakao2017;

import java.util.HashMap;
import java.util.HashSet;

public class BriansWorry3 {
    HashMap<Character, Integer> numRule = new HashMap<>();
    HashSet<Character> checkChar = new HashSet<>();
    public String solution(String sentence) {
        StringBuilder sb = new StringBuilder();
        makeNumChar(sentence);
        char nowRule = ' ';
        int startRule2=-1;
        int endRule2=-1;
        char preChar = ' ';

        if(sentence.indexOf(" ")!=-1){
            return "invalid";
        }

        for (Character character : numRule.keySet()) {
            if(numRule.get(character) == 2){
                startRule2 = sentence.indexOf(character);

                if(endRule2 > startRule2){
                    return "invalid";
                }
                endRule2 = sentence.lastIndexOf(character);
                if(endRule2-startRule2==1){
                    return "invalid";
                }
                sentence = sentence.replaceAll(character+""," ");
            }
        }

        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if(c < 'a'){
                if( preChar < 'a' && preChar!=' ' && nowRule !=' '){
                    sb.append(" ");
                    nowRule = ' ';
                }
                sb.append(c);

                if(c==' '){
                    if(preChar == nowRule && preChar != ' '){
                        return "invalid";
                    }
                    nowRule = ' ';
                }
            }else{
                if(nowRule == ' '){
                    nowRule = c;
                    if(checkChar.contains(c)){
                        return "invalid";
                    }
                    checkChar.add(c);
                } else if (nowRule != c) {
                    return "invalid";
                } else if (i == sentence.length()-1){
                    return "invalid";
                }

                if(preChar >= 'a'){
                    return "invalid";
                }
            }
            preChar = c;
        }
        return sb.toString().replaceAll("[ ]+"," ").trim();
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
//        sentence = "SpIpGpOpNpGJqOqA";
        sentence = "xAaAbAaAx";
        sentence = "HELLOWORLD";
        BriansWorry3 briansWorry = new BriansWorry3();
        System.out.println("briansWorry.solution(sentence) = " + briansWorry.solution(sentence));
    }
}
