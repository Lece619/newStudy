package kakao2020;

import java.util.*;
/*
* 1 2 3
* 4 5 6
* 7 8 9
* * 0 #
*
* */
public class KeyPad {
    public static void main(String[] args) {
        int[] numbers={1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand="right";
        new Solution().solution(numbers,hand);
    }
    static class Solution {
        public String solution(int[] numbers, String hand) {
            HashMap<Character,Integer[]> keyMap =new HashMap<>();
            keyMap.put('1', new Integer[]{0, 0});
            keyMap.put('2', new Integer[]{1, 0});
            keyMap.put('3', new Integer[]{2, 0});
            keyMap.put('4', new Integer[]{0, 1});
            keyMap.put('5', new Integer[]{1, 1});
            keyMap.put('6', new Integer[]{2, 1});
            keyMap.put('7', new Integer[]{0, 2});
            keyMap.put('8', new Integer[]{1, 2});
            keyMap.put('9', new Integer[]{2, 2});
            keyMap.put('*', new Integer[]{0, 3});
            keyMap.put('0', new Integer[]{1, 3});
            keyMap.put('#', new Integer[]{2, 3});

            char left = '*';
            char right = '#';
            String answer = "";

            for (int i = 0; i < numbers.length; i++) {
                char number = (char)numbers[i];
                Integer[] currentNum=keyMap.get(number);
                int lenghLeft = keyMap.get(left)[0]-currentNum[0]+
                                    keyMap.get(left)[1] - currentNum[1];
                int lenghRight = keyMap.get(right)[0] - currentNum[0]+
                                    keyMap.get(left)[1] - currentNum[1];
                if(lenghLeft<lenghRight){
                    answer+=(int)number;
                }
            }

            return answer;
        }
    }
}
