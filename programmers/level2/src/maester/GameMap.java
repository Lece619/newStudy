//https://programmers.co.kr/learn/courses/30/lessons/1844
//코딩테스트 연습 - 찾아라 프로그래밍 마에스터 - 게임 맵 최단거리
package maester;

import java.util.ArrayList;

public class GameMap {

    static int min = -1;
    static boolean[][] check;
    static int n, m;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, -1, 0, 1};

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        check = new boolean[n][m];
        ArrayList<int[]> list = new ArrayList<>();
        boolean endCheck = false;
        list.add(new int[]{0,0});
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(maps[i][j]==1){
                    check[i][j] = true;
                }
            }
        }
        check[0][0]=false;
        int step = 1;


        while(!endCheck){
            step++;
            endCheck = true;
            ArrayList<int[]> temp = new ArrayList<>();
            //하나라도 이동 가능하다면
            for (int[] ints : list) {
                for (int i = 0; i < 4; i++) {
                    int x = ints[0] + moveX[i];
                    int y = ints[1] + moveY[i];
                    if(moveOk(x,y)){
                        check[x][y]=false;
                        temp.add(new int[]{x,y});
                        endCheck = false;
                        if(x==n-1&&y==m-1){
                            return step;
                        }
                    }
                }
            }
            list = temp;
        }
        int answer = 0;
        if(endCheck){
            answer = step;
        }else{
            answer = -1;
        }

        return -1;
    }
    public boolean moveOk(int x, int y){
        if(x < 0 || x >= n || y < 0 || y >= m ){
            return false;
        }
        return check[x][y];
    }


    public static void main(String[] args) {
        //테스트
        //int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}};
        System.out.println(new GameMap().solution(maps));
    }
}
