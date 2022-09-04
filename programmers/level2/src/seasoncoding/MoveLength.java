/*
https://school.programmers.co.kr/learn/courses/30/lessons/49994
        Summer/Winter Coding(~2018)
        방문 길이
*/

package seasoncoding;

import java.util.HashSet;
import java.util.Objects;

public class MoveLength {
    int nowX = 0;
    int nowY = 0;
    int[] arrX = {0, 0, 1, -1};
    int[] arrY = {1, -1, 0, 0};
    HashSet<Load> set = new HashSet<>();
    //'U', 'D', 'R', 'L'
    public int solution(String dirs) {
        makeMove(dirs);
        return set.size();
    }

    private void makeMove(String dirs) {
        String command = "UDRL";
        for (int i = 0; i < dirs.length(); i++) {
            int num = command.indexOf(dirs.charAt(i));
            int nextX = nowX + arrX[num];
            int nextY = nowY + arrY[num];

            if( nextX < -5 || nextX > 5 || nextY < -5 || nextY > 5){
                continue;
            }
            set.add(new Load(nowX, nowY, nextX, nextY));
            nowX = nextX;
            nowY = nextY;
        }
    }

    static class Load {
        int x1;
        int y1;
        int x2;
        int y2;

        public Load(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Load load = (Load) o;
            return (x1 == load.x1 && y1 == load.y1 && x2 == load.x2 && y2 == load.y2) ||
                    (x1 == load.x2 && y1 == load.y2 && x2 == load.x1 && y2 == load.y1);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2) + Objects.hash(x2, y2, x1, y1);
        }
    }

    public static void main(String[] args) {

        MoveLength moveLength = new MoveLength();
        System.out.println("moveLength = " + moveLength.solution("LULLLLLLU"));

    }
}
