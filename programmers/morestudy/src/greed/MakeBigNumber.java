/*
https://school.programmers.co.kr/learn/courses/30/lessons/42883
        탐욕법(Greedy)
        큰 수 만들기
*/

package greed;

import java.util.*;
import java.util.stream.Collectors;

public class MakeBigNumber {
    public String solution(String number, int k) {

        Stack<Integer> checkBigNumber = new Stack<>();
        int[] numbers = number.chars().mapToObj(i -> Integer.parseInt(String.valueOf((char) i))).mapToInt(i->i).toArray();

        for (int i : numbers) {
            while(!checkBigNumber.isEmpty()  && checkBigNumber.peek() < i){
                if( k > 0 ) {
                    checkBigNumber.pop();
                    k--;
                }
                if(k==0){
                    break;
                }
            }
            checkBigNumber.add(i);
        }
        for (int i = 0; i < k; i++) {
            checkBigNumber.pop();
        }

        return new ArrayList<>(checkBigNumber).stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        MakeBigNumber makeBigNumber = new MakeBigNumber();
        makeBigNumber.solution("4177252841",4);
    }
}
