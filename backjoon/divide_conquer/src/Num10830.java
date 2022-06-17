import java.util.Scanner;

//https://www.acmicpc.net/problem/10830
//행렬 제곱
public class Num10830 {

    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        long B = sc.nextLong();

        long[][] matrix = new long[N][N];
        long[][] result = new long[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
            result[i][i] = 1;
        }
        while(B > 0){
            if(B % 2 == 1){
                result = multiMatrix( result, matrix );
            }
            B /= 2;
            matrix = multiMatrix( matrix, matrix );
        }

        for (long[] ints : result) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static long[][] multiMatrix(long[][] matrix1,long[][] matrix2){
        long[][] resutlMatrix = new long[N][N];

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
