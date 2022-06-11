//https://programmers.co.kr/learn/courses/30/lessons/86052?language=java
//월간 코드 챌린지 - 빛의 경로 사이트
package challenge;

import java.util.ArrayList;

public class LightCycle {
    //방문 확인 => 방향에 따라 4곳.
    static boolean[][][] visited;
    static int rowLen, columnLen;
    //이동후 row column 이 오 아래 왼 위 일때
    //방향이 0 -> 오  1-> 아래  2 -> 왼  3 -> 위
    static int[] nextRow = {0, -1, 0, 1};
    static int[] nextColumn = {1, 0 , -1, 0};

    public int[] solution(String[] grid) {
        int[] answer = {};

        ArrayList<Integer> lengths  = new ArrayList<>();

        rowLen = grid.length;
        columnLen = grid[0].length();
        visited = new boolean[rowLen][columnLen][4];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                //각 자리마다 위치로 4방향 확인을 진행
                for (int direction = 0; direction < 4; direction++) {
                    //해당 방향으로 들어온적이 없다면, 즉 시작점이라면
                    if(!visited[i][j][direction]){
                        lengths.add(root(grid,i,j,direction));
                    }
                }
            }
        }

        answer = lengths.stream().sorted().mapToInt(i->i).toArray();
        return answer;
    }

    public static int root(String[] grid, int row, int column, int direction){
        int step = 0;
        //해당 방향으로 들어온적 있는지 조사하면서 row, column 위치를 이동시켜준다.
        while(true) {
            //들어온적 있다면 = true
            if((visited[row][column][direction])){
                break;
            }
            //없다면 이 방향으로의 스탭을 올려주고 흔적을 true로 변경해준다.
            step++;
            visited[row][column][direction] = true;
            
            //좌회전 일때 = 오른쪽 -> 위,  위 -> 왼,  왼 -> 아래 , 아래 -> 오
            //index 로는 =  0   -> 3,   3 -> 2,   2 -> 1   ,  1   -> 0  반시계방향 회전 1씩 감소
            if(grid[row].charAt(column)=='L'){
                direction = ( (direction - 1) + 4 ) % 4;
            }
            //우회전 일때는 시계방향 => 인덱스 방향으로 이동 3 이후 4 => 0
            else if (grid[row].charAt(column)=='R') {
                direction = (direction + 1) % 4;
            }
            //다음 row,column 이 0 이상 각 행,열의 길이 이하이기 때문에
            // 바로 위 방향 방식과 동일하게 다음 행,열을 구해준다.
            row = (row + nextRow[direction] + rowLen) % rowLen;
            column = (column + nextColumn[direction] + columnLen) % columnLen;
        }

        return step;
    }


    public static void main(String[] args) {
        String[] grid = {"SLLR","LRLR"};
        new LightCycle().solution(grid);
        System.out.println();
    }
}
