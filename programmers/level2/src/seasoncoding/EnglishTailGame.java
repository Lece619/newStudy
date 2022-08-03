/*
https://school.programmers.co.kr/learn/courses/30/lessons/12981
        코딩테스트 연습
        Summer/Winter Coding(~2018)
        영어 끝말잇기
*/
package seasoncoding;

import java.util.HashSet;
import java.util.Set;

public class EnglishTailGame {

    Set<String> wordSet;
    char last;

    public int[] solution(int n, String[] words) {

        wordSet = new HashSet<>();
        int index = 0;
        last = words[index].charAt(words[index].length()-1);
        wordSet.add(words[index]);
        for (index = 1; index < words.length; index++) {
            if(!checkWord(words[index])){
                break;
            }
        }
        int[] answer = index == words.length ? new int[]{0, 0} : new int[]{(index % n) + 1, index / n + 1};
        return answer;
    }

    public boolean checkWord(String word){
        if(word.charAt(0) != last){
            return false;
        }else if(wordSet.contains(word)){
            return false;
        }else{
            wordSet.add(word);
            last = word.charAt(word.length()-1);
            return true;
        }
    }



    public static void main(String[] args) {
        EnglishTailGame englishTailGame = new EnglishTailGame();
        int n = 3;

        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        System.out.println(englishTailGame.solution(n, words)[0]);
        System.out.println(englishTailGame.solution(n, words)[1]);

    }
}
