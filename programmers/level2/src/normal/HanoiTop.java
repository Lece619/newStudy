package normal;

import java.util.ArrayList;
import java.util.Collections;

public class HanoiTop {

    public static int idx;
    public static ArrayList<int[]> ansList;

    public int[][] solution(int n) {

        ansList = new ArrayList<>();
        hanoi(n,1,3,2);
        int[][] answer = new int[ansList.size()][2];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i][0] = ansList.get(i)[0];
            answer[i][1] = ansList.get(i)[1];
        }
        return answer;
    }

    public void hanoi(int N, int start, int end, int via){
        if(N==1) {
            ansList.add(new int[]{start, end});
            System.out.println(start + " " + end);
        } else {
            hanoi(N-1, start, via, end);
            ansList.add(new int[]{start, end});
            System.out.println(start + " " + end);
            hanoi(N-1, via, end, start);
        }
    }

    public static void main(String[] args) {
        new HanoiTop().solution(2);
    }
}
