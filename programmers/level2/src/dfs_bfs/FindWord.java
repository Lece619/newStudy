/*
https://school.programmers.co.kr/learn/courses/30/lessons/84512
        완전탐색
        모음사전
*/

package dfs_bfs;

import java.util.ArrayList;
import java.util.List;

public class FindWord {

    List<String> list = new ArrayList<>();
    String[] str = {"A", "E", "I", "O", "U"};
    String target;

    public int solution(String word) {
        target = word;
        dfs("",0);
        return list.indexOf(word)+1;
    }

    private void dfs(String word , int num) {
        if(num == 5){
            return;
        }else{
            for (int i = 0; i < str.length; i++) {
                String newWord = word + str[i];
                list.add(newWord);
                dfs(newWord, num+1);
            }
        }
    }

    public static void main(String[] args) {
        FindWord findWord = new FindWord();
        System.out.println("findWord.solution(\"\") = " + findWord.solution("I"));
    }
}
