//https://programmers.co.kr/learn/courses/30/lessons/86052?language=java
//월간 코드 챌린지 - 빛의 경로 사이트
package challenge;

public class LightCycle {
    static boolean[][] right;
    static int lenX;
    static int lenY;

    public int[] solution(String[] grid) {
        int[] answer = {};
        lenX = grid.length;
        lenY = grid[0].length();
        char[][] command =new char[grid.length][grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            command[i]=grid[i].toCharArray();
        }
        for (char[] chars : command) {
            System.out.println();
            for (char aChar : chars) {
                System.out.print(" "+aChar);
            }
        }
        return answer;
    }




    public static void main(String[] args) {
        String[] grid = {"SLLR","LRLR"};
        new LightCycle().solution(grid);
        System.out.println();
    }
}
