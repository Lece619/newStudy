/*
https://school.programmers.co.kr/learn/courses/30/lessons/42839
        완전탐색
        소수 찾기
*/
package bruteforce;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllNumPrimary {

    HashSet<Integer> allNumber = new HashSet<>();
    boolean[] check;
    public int solution(String numbers) {
        int answer = 0;
        List<String> strings = numbers.chars().mapToObj(i->String.valueOf((char)i)).collect(Collectors.toList());
        check =new boolean[strings.size()];
        makeNumber("",strings);
        for (Integer integer : allNumber) {
            answer += findPrimary(integer);
        }
        System.out.println("allNumber = " + allNumber);
        return answer;
    }

    private int findPrimary(Integer integer) {
        for (int i = 2; i <= Math.sqrt(integer); i++) {
            if(integer % i == 0){
                return 0;
            }
        }
        return integer < 2 ? 0 : 1;
    }

    private void makeNumber(String str, List<String> strings) {
        if(!str.equals("")){
            allNumber.add(Integer.parseInt(str));
        }
        if(str.length() == strings.size()){
            return;
        }
        for (int i = 0; i < strings.size(); i++) {
            if(!check[i]) {
                String s = strings.get(i);
                check[i] = true;
                makeNumber(str + s, strings);
                check[i] = false;
            }
        }
    }



    public static void main(String[] args) {
        FindAllNumPrimary findAllNumPrimary = new FindAllNumPrimary();
        int solution = findAllNumPrimary.solution("123");
        System.out.println("solution = " + solution);
    }
}
