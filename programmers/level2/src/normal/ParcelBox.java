/*
https://school.programmers.co.kr/learn/courses/30/lessons/131704
        연습문제
        택배상자
*/

package normal;

import java.util.Stack;

public class ParcelBox {

    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> subBelt = new Stack<>();
        int idx = 0;
        subBelt.add(0);
        for (int i = 1; i < order.length+2; i++) {

            if(order[idx] != i){
                while(subBelt.peek() == order[idx]){
                    subBelt.pop();
                    answer++;
                    idx++;
                    if(idx==order.length){
                        break;
                    }
                }
                subBelt.add(i);
            }else{
                answer++;
                idx++;
                while(subBelt.peek() == order[idx]){
                    subBelt.pop();
                    answer++;
                    idx++;
                    if(idx==order.length-1){
                        break;
                    }
                }
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        ParcelBox parcelBox = new ParcelBox();
        int[] order = {5, 4, 3, 2, 1};
        int solution = parcelBox.solution(order);
        System.out.println("solution = " + solution);
    }
}
