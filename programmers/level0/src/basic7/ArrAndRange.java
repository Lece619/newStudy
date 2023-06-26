package basic7;

public class ArrAndRange {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            executeQuery(arr, query);
        }
        return arr;
    }

    private void executeQuery(int[] arr, int[] query) {
        int start = query[0];
        int end = query[1];
        int num = query[2];
        for (int i = start; i <= end; i++) {
            if( i % num == 0)
                arr[i] += 1;
        }
    }
}
