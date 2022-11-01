/*
https://school.programmers.co.kr/learn/courses/30/lessons/133500
        연습문제
        등대
*/

package normal;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class LightHouse2 {
    int answer = 0;
    public int solution(int n, int[][] lighthouse) {

        ArrayList<ArrayList<Integer>> linked = new ArrayList<>();
        IntStream.rangeClosed(0,n).forEach(i->linked.add(new ArrayList<>()));
        for (int[] ints : lighthouse) {
            linked.get(ints[0]).add(ints[1]);
            linked.get(ints[1]).add(ints[0]);
        }

        return 0;
    }



    public static void main(String[] args) {
        LightHouse2 lightHouse = new LightHouse2();
        int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        int solution = lightHouse.solution(n, lighthouse);
        System.out.println("solution = " + solution);
    }
}
