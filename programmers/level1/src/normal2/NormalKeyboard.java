/*
https://school.programmers.co.kr/learn/courses/30/lessons/160586
        연습문제
        대충 만든 자판
*/

package normal2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NormalKeyboard {
    public int[] solution(String[] keymap, String[] targets) {

        Map<Character, Integer> key = new HashMap<>();
        makeKeys(key, keymap);
        System.out.println("key = " + key);
        return answerByKey(key, targets);
    }

    private void makeKeys(Map<Character, Integer> key, String[] keymap) {
        for (String nowKey : keymap) {
            for (int i = 0; i < nowKey.length(); i++) {
                char keyChar = nowKey.charAt(i);
                key.put(keyChar, Math.min(key.getOrDefault(keyChar, Integer.MAX_VALUE), i + 1));
            }
        }
    }

    private int[] answerByKey(Map<Character, Integer> key, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i = 0; i < answer.length; i++) {
            int totalTyping = 0;
            for (char target : targets[i].toCharArray()) {
                Integer targetNum = key.getOrDefault(target, 0);
                if(targetNum == 0){
                    totalTyping = -1;
                    break;
                }
                totalTyping += targetNum;
            }
            answer[i]  = totalTyping;
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] tarwgets = {"ABCD","AABB"};
        NormalKeyboard normalKeyboard = new NormalKeyboard();
        int[] solution = normalKeyboard.solution(keymap, tarwgets);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
