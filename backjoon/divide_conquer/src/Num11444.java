//Numhttps://www.acmicpc.net/problem/11444
//백준 알고리즘 - 분할정복 - 피보나치 수 6

import java.util.Scanner;

public class Num11444 {
    /*
     * 1 1
     * 1 0 의 거듭제곱이 피보나치의 수
     * 1,000,000,007 나눈 나머지
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong() - 1;

        long[][] result = {{1, 0}, {0, 1}};
        long[][] matrix = {{1, 1}, {1, 0}};


        while (n > 0) {
            if (n % 2 == 1) {
                result = multiMatrix(result, matrix);
            }
            n /= 2;
            matrix = multiMatrix(matrix, matrix);
        }

        System.out.println(result[0][0]);

        for (long[] ints : result) {
            for (long anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static long[][] multiMatrix(long[][] matrix1, long[][] matrix2) {
        long[][] resutlMatrix = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {

                for (int k = 0; k < 2; k++) {
                    resutlMatrix[i][j] = (resutlMatrix[i][j] + matrix1[i][k] * matrix2[k][j]) % 1000000007;
                }

            }
        }

        return resutlMatrix;
    }
}
