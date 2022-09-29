/*
https://school.programmers.co.kr/learn/courses/30/lessons/77486
2021 Dev-Matching: 웹 백엔드 개발자(상반기)
        다단계 칫솔 판매
*/

package devmatching2021;

import java.util.HashMap;

public class SellToothbrush {

    HashMap<String, String> recommend = new HashMap<>();
    HashMap<String, Integer> officerNum = new HashMap<>();
    int[] answer;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            recommend.put(enroll[i], referral[i]);
            officerNum.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            sellBrush(seller[i], amount[i] * 100L);
        }

        return answer;
    }

    private void sellBrush(String seller, long price) {
        if((price/10)< 1){
            answer[officerNum.get(seller)] += price;
            return;
        }
        long upPrice = price / 10;
        long ownPrice = price - upPrice;

        answer[officerNum.get(seller)] += ownPrice;
        if(!recommend.get(seller).equals("-")){
           sellBrush(recommend.get(seller), upPrice);
        }
    }

    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};

        SellToothbrush sellToothbrush = new SellToothbrush();
        int[] solution = sellToothbrush.solution(enroll, referral, seller, amount);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
