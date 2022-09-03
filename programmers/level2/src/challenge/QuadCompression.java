/*
https://school.programmers.co.kr/learn/courses/30/lessons/68936
        월간 코드 챌린지 시즌1
        쿼드압축 후 개수 세기
*/
package challenge;

public class QuadCompression {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        compression(arr);
        return answer;
    }

    private void compression(int[][] arr) {

        int n = arr.length;

        if( n == 1){
            answer[arr[0][0]]++;
            return;
        }

        if(canCompress(arr)){
            return;
        }

        n /= 2;
        int[][] arr1 = makeSplitArr(arr, 0, 0, n);
        int[][] arr2 = makeSplitArr(arr, 1, 0, n);
        int[][] arr3 = makeSplitArr(arr, 0, 1, n);
        int[][] arr4 = makeSplitArr(arr, 1, 1, n);

        compression(arr1);
        compression(arr2);
        compression(arr3);
        compression(arr4);

    }

    private boolean canCompress(int[][] arr) {
        int n = arr.length * arr.length;
        int sum = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        if(sum == 0 || sum == n){
            answer[sum == 0? 0 : 1]++;
            return true;
        }
        return false;
    }

    private int[][] makeSplitArr(int[][] arr, int x, int y, int n) {
        int[][] result = new int[n][n];
        int startX = n * x;
        int startY = n * y;
        for (int i = startX ; i < startX + n; i++) {
            for (int j = startY; j < startY + n; j++) {
                result[i - startX][j - startY] = arr[i][j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        QuadCompression test = new QuadCompression();
        int[] answer = new int[2];
        int[][] sample = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        sample = new int[][]{{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        answer = test.solution(sample);
        System.out.println("answer[0] = " + answer[0]);
        System.out.println("answer[1] = " + answer[1]);
    }
}
