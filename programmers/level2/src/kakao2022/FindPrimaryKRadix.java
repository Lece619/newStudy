/*
https://school.programmers.co.kr/learn/courses/30/lessons/92335
        2022 KAKAO BLIND RECRUITMENT
        k진수에서 소수 개수 구하기
*/
package kakao2022;

import javax.print.attribute.IntegerSyntax;
import java.util.HashSet;

public class FindPrimaryKRadix {

    HashSet<String> primary = new HashSet<>();
    public int solution(int n, int k) {
        int answer = 0;
        String s = Integer.toString(n, k);
        s = s.replaceAll("0+", " ");
        String[] find = s.split(" ");
        for (String s1 : find) {
            answer += findPrimary(s1);
        }
        return answer;
    }

    private int findPrimary(String s1) {

        if(s1.equals("1")){
            return 0;
        }

        if(primary.contains(s1)){
            return 1;
        }
        long num = Long.parseLong(s1);
        long n = (long)Math.sqrt(num);
        for (int i = 2; i < n + 1; i++) {
            if(num % i == 0){
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        FindPrimaryKRadix findPrimaryKRadix = new FindPrimaryKRadix();
        System.out.println("findPrimaryKRadix.solution(1, 3) = " + findPrimaryKRadix.solution(437674, 3));
    }
}
