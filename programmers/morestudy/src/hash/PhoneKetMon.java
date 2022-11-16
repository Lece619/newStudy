/*
https://school.programmers.co.kr/learn/courses/30/lessons/1845
        해시
        폰켓몬
*/

package hash;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PhoneKetMon {
    public int solution(int[] nums) {

        int size = Arrays.stream(nums).boxed().collect(Collectors.toSet()).size();

        return Math.min(nums.length / 2, size);
    }

    public static void main(String[] args) {

        int[] num = {3,3,3,2,2,4};

        PhoneKetMon phoneKetMon = new PhoneKetMon();
        int solution = phoneKetMon.solution(num);
        System.out.println("solution = " + solution);
    }
}
