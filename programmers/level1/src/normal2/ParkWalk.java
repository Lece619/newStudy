/*
https://school.programmers.co.kr/learn/courses/30/lessons/172928
        연습문제
        공원 산책
*/

package normal2;

import java.util.HashSet;
import java.util.Set;

public class ParkWalk {

    int nowI = 0;
    int nowJ = 0;
    int limitI = 0;
    int limitJ = 0;

    Set<String> blockedRoute = new HashSet<>();
    public int[] solution(String[] park, String[] routes) {

        limitI = park.length;
        limitJ = park[0].length();

        char[][] parkRoute = new char[limitI][limitJ];

        for (int i = 0; i < limitI; i++) {
            for (int j = 0; j < limitJ; j++) {
                parkRoute[i][j] = park[i].charAt(j);
                addRouteOption(parkRoute[i][j], i, j);
            }
        }

        for (String route : routes) {
            moveStep(route);
        }
        return new int[]{nowI, nowJ};
    }

    private void moveStep(String route) {
        String[] roureOption = route.split(" ");
        Direction direction = Direction.valueOf(roureOption[0]);
        int step = Integer.parseInt(roureOption[1]);
        int newI = nowI + direction.i * step;
        int newJ = nowJ + direction.j * step;
        if(validateStep(newI, newJ)){
            nowI = newI;
            nowJ = newJ;
        }
    }

    private boolean validateStep(int newI, int newJ) {
        if(newI < 0 || newI >= limitI){
            return false;
        }
        if(newJ < 0 || newJ >= limitJ){
            return false;
        }
        for (int i = Math.min(nowI, newI); i <= Math.max(nowI,newI); i++) {
            for (int j = Math.min(nowJ, newJ); j <= Math.max(nowJ,newJ); j++){
                if(blockedRoute.contains(i + " " + j)){
                    return false;
                }
            }
        }

        return true;
    }

    private void addRouteOption(char parkRoute, int i, int j) {
        if(parkRoute == 'S'){
            nowI = i;
            nowJ = j;
        }
        if(parkRoute == 'X'){
            blockedRoute.add(i + " " + j);
        }
    }

    enum Direction{
        E( 0, 1),
        W(0, -1),
        S( 1, 0),
        N(-1, 0);

        final int i;
        final int j;
        Direction( int i, int j) {
            this.i = i;
            this.j = j;
        }

    }

    public static void main(String[] args) {
        ParkWalk parkWalk = new ParkWalk();
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routh = {"E 2","S 3","W 1"};
        int[] solution = parkWalk.solution(park, routh);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
