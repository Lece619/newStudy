/*
https://school.programmers.co.kr/learn/courses/30/lessons/86971
코딩테스트 연습 완전탐색 전력망을 둘로 나누기
*/


package dfs_bfs;

import java.util.HashSet;
import java.util.Set;

public class SplitWire {
    int totalNum;
    public int solution(int n, int[][] wires) {
        totalNum = n;
        if(totalNum == 2){
            return 0;
        }
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            minNum = Integer.min(findSetNum2(wires , i), minNum);
        }

        return minNum;
    }

    private int findSetNum(int[][] wires, int num) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        numSet1.add(wires[num][0]);
        numSet2.add(wires[num][1]);
        int size = 0;
        while(size != totalNum){
            for (int i = 0; i < wires.length; i++) {
                if(i == num){
                    continue;
                }
                if(numSet1.contains(wires[i][0]) || numSet1.contains(wires[i][1])) {
                    numSet1.add(wires[i][0]);
                    numSet1.add(wires[i][1]);
                }
                if(numSet2.contains(wires[i][0]) || numSet2.contains(wires[i][1])){
                    numSet2.add(wires[i][0]);
                    numSet2.add(wires[i][1]);
                }
                size = numSet1.size() + numSet2.size();
            }
        }
        return Math.abs(numSet1.size() - numSet2.size());
    }

    //Set 한개만 확인 더 빠름.
    private int findSetNum2(int[][] wires, int num) {
        Set<Integer> numSet1 = new HashSet<>();
        numSet1.add(wires[num][0]);
        boolean flag = true;
        while(flag){
            flag = false;
            for (int i = 0; i < wires.length; i++) {
                if(i == num || ( numSet1.contains(wires[i][0]) && numSet1.contains(wires[i][1]))){
                    continue;
                }
                if(numSet1.contains(wires[i][0]) || numSet1.contains(wires[i][1])) {
                    numSet1.add(wires[i][0]);
                    numSet1.add(wires[i][1]);
                    flag = true;
                }
            }
        }
        return Math.abs((totalNum - numSet1.size()) - numSet1.size());
    }

    public static void main(String[] args) {
        int n = 9;
//        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        n=6;
        int[][] wires = {{1, 4}, {6, 3}, {2, 5}, {5, 1}, {5, 3}};
        System.out.println("new SplitWire().solution(answer,wires) = " + new SplitWire().solution(n, wires));
    }
}
