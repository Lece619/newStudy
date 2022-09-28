package devmatching2021;

public class RotationMatrix {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numbers[i][j]=i*columns+j+1;
            }
        }
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rotate(queries[i],numbers);
        }

        return answer;
    }
    //x1 < x2 y1< y2
    public int rotate(int[] query,int[][] numbers){
        int x1 = query[0]-1;
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        //x1에서 y2->y1
        int temp=numbers[x1][y2];
        int min = temp;
        for (int i = y2; i > y1 ; i--) {
            numbers[x1][i]=numbers[x1][i-1];
            min=Math.min(min,numbers[x1][i]);
        }
        //y1에서 x1->x2
        for (int i = x1; i <x2; i++) {
            numbers[i][y1]=numbers[i+1][y1];
            min=Math.min(min,numbers[i][y1]);
        }
        //x2에서 y1->y2
        for (int i = y1; i < y2; i++) {
            numbers[x2][i]=numbers[x2][i+1];
            min=Math.min(min,numbers[x2][i]);
        }
        //y2에서 x2->x1;
        for (int i = x2; i > x1 ; i--) {
            numbers[i][y2]=numbers[i-1][y2];
            min=Math.min(min,numbers[i][y2]);
        }
        numbers[x1+1][y2]=temp;
        return min;
    }

}
