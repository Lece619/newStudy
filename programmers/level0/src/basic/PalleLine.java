package basic;

public class PalleLine {
    public int solution(int[][] dots) {
        int x1 = dots[3][0];
        int y1 = dots[3][1];
        for (int i = 0; i < 3; i++) {
            int x2 = dots[i][0];
            int y2 = dots[i][1];
            int x3 = dots[(i+1)%3][0];
            int y3 = dots[(i+1)%3][1];
            int x4 = dots[(i+2)%3][0];
            int y4 = dots[(i+2)%3][1];
            if(x1 == x2 || x3 == x4){
                if(x1 == x2 && x3 == x4){
                    return 1;
                }
                continue;
            }
            if((y2-y1)/(double)(x2-x1)==(y4-y3)/(double)(x4-x3)){
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] dots = {{1, 4}, {9, 2}, {3, 8}, {10, 4}};
        PalleLine palleLine = new PalleLine();
        palleLine.solution(dots);

    }
}
