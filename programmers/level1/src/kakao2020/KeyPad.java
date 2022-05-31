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
        int[] numbers={7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand="left";
        System.out.println(new Solution().solution(numbers,hand));
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
            hand = hand.equals("left") ? "L" : "R";
            char left = '*';
            char right = '#';
            String answer = "";

            for (int i = 0; i < numbers.length; i++) {
                char number = Integer.toString(numbers[i]).charAt(0);
                Integer[] currentNum=keyMap.get(number);
                if(number!='2'&&number!='5'&&number!='8'&&number!='0'){
                    if(number=='1'||number=='4'||number=='7'){
                        left=number;
                        answer+="L";

                    }else{
                        right=number;
                        answer+="R";
                    }
                }
                else {

                    int lenghLeft = Math.abs(keyMap.get(left)[0] - currentNum[0]) +
                            Math.abs(keyMap.get(left)[1] - currentNum[1]);
                    int lenghRight = Math.abs(keyMap.get(right)[0] - currentNum[0]) +
                            Math.abs(keyMap.get(right)[1] - currentNum[1]);
                    if (lenghLeft < lenghRight) {
                        answer += "L";
                        left = number;
                    } else if (lenghLeft == lenghRight) {
                        answer += hand;
                        if (hand.equals("L")) {
                            left = number;
                        } else {
                            right = number;
                        }
                    } else {
                        answer += "R";
                        right = number;
                    }
                }
                System.out.println(answer);
                System.out.println(number+"누르기 "+"left : " + left + "  right : "+right);
            }

            return answer;
        }
    }
}
