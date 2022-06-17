import java.util.Scanner;

//https://www.acmicpc.net/problem/10830
//행렬 제곱
public class Num10830 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int B = sc.nextInt();

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

    }

    public int[][] mutiMatrix(int[][] matrix1,int[][] matrix2){
        int[][] resutlMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                for (int k = 0; k < N; k++) {
                    resutlMatrix [i][j] = ( resutlMatrix[i][j] + matrix1[i][k] * matrix2[k][j] ) % 1000;
                }

            }
        }

        return resutlMatrix;
    }
}
