//https://programmers.co.kr/learn/courses/30/lessons/12939
//코딩테스트 연습
//연습문제
//최댓값과 최솟값

package normal;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxMin {

    public String solution(String s) {
        int[] a = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(a);
        return a[0]+""+a[a.length-1];
    }

}
