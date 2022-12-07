package basic4;

public class RecArea {
    public int solution(int[][] dots) {

        int widthStart = dots[0][0];
        int heightStart = dots[0][1];
        int widthEnd = 0;
        int heightEnd = 0;

        for (int i = 1; i < 4; i++) {
            if(widthStart != dots[i][0]){
                widthEnd = dots[i][0];
            }
            if(heightStart != dots[i][1]){
                heightEnd = dots[i][1];
            }
        }

        return Math.abs( widthStart - widthEnd) * Math.abs( heightStart - heightEnd );
    }
}
