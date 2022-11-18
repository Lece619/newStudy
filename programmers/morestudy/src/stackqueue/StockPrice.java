/*
https://school.programmers.co.kr/learn/courses/30/lessons/42584
        스택/큐
        주식가격
*/
package stackqueue;

import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int sec = 0;
            for (int j = i + 1; j < prices.length; j++) {
                sec++;
                if(price > prices[j]){
                    break;
                }
            }
            answer[i] = sec;
        }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1,2,3,2,3};
        int[] solution = stockPrice.solution(prices);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
