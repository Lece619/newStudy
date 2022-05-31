//https://programmers.co.kr/learn/courses/30/lessons/12973
//프로그래머스 - 짝지어 제거하기

package tipstown2017;

import java.util.HashSet;
import java.util.stream.IntStream;

public class RemoveCouple {
    public int solution(String s)
    {
        int answer = -1;
        HashSet<String> set = new HashSet<>();
        IntStream.range(0,s.length()).forEach(i->set.add(s.charAt(i)+""));
        System.out.println(set);
        return answer;
    }

    public static void main(String[] args) {
        new RemoveCouple().solution("asdfafas");
    }
}
