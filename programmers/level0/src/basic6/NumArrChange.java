package basic6;

import java.util.Arrays;

public class NumArrChange {
    int index = 0;
    boolean isSame = false;
    public int solution(int[] arr) {
        while(!isSame) {
            index++;
            arr = findNextArr(arr);
        }
        return index - 1;
    }

    private int[] findNextArr(int[] arr) {
        isSame = true;
        int[] array = Arrays.stream(arr).map(num -> {
            if (num % 2 == 0 && num >= 50) {
                isSame = false;
                return num / 2;
            }
            if (num % 2 == 1 && num < 50) {
                isSame = false;
                return num * 2 + 1;
            }
            return num;
        }).toArray();
        return array;
    }

    public static void main(String[] args) {
        new NumArrChange().solution(new int[]{1, 2, 3, 100, 99, 98});
    }
}
