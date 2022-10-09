/*
https://school.programmers.co.kr/learn/courses/30/lessons/131127
        연습문제
        할인 행사
*/

package normal;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SaleEvent {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> changeMap = IntStream.range(0, want.length).mapToObj(i -> Integer.parseInt(String.valueOf(i))).collect(Collectors.toMap(i -> want[(int) i], i -> number[(int) i]));
        for (int i = 0; i < 10; i++) {
            if(changeMap.containsKey(discount[i])){
                changeMap.put(discount[i], changeMap.get(discount[i]) - 1);
            }
        }
        int size = changeMap.size();
        long count = changeMap.values().stream().filter(val -> val <= 0).count();
        System.out.println("size = " + size);
        System.out.println("count = " + count);
        if(size == count){
            answer++;
        }
//        0 - 9 1 - 10
        for (int i = 0; i < discount.length - 10; i++) {
            if(changeMap.containsKey(discount[i])){
                changeMap.put(discount[i], changeMap.get(discount[i]) + 1);
            }
            if(changeMap.containsKey(discount[i+10])){
                changeMap.put(discount[i+10], changeMap.get(discount[i+10]) - 1);
            }
            count = changeMap.values().stream().filter(val -> val <= 0).count();
            if(size == count){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number= {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        SaleEvent saleEvent = new SaleEvent();
        System.out.println("saleEvent.solution(wn) = " + saleEvent.solution(want, number, discount));
    }
}
