/*
https://school.programmers.co.kr/learn/courses/30/lessons/120956?language=java
        코딩테스트 입문
        옹알이
*/

package basic;

public class Babbling {

    public int solution(String[] babbling) {
        int answer = 0;
        String[] ableWord = {"aya", "ye", "woo", "ma"};

        for (String word : babbling) {
            if(checkAble(word, ableWord)){
                answer++;
            }
        }
        
        return answer;
    }

    private boolean checkAble(String word, String[] ableWord) {
        for (int i = 0; i < ableWord.length; i++) {
            word = word.replaceAll(ableWord[i],i+"");
            if(word.contains(i+""+i)){
                return false;
            }
        }

        return word.replaceAll("\\d","").length() == 0;
    }


    public static void main(String[] args) {
        Babbling babblingTest = new Babbling();
        String[] babbling = {"aya", "yee", "u", "maa"};
        int solution = babblingTest.solution(babbling);
        System.out.println("solution = " + solution);
    }
}
