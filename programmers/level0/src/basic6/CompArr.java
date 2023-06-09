package basic6;

import java.util.Arrays;

public class CompArr {
    public int solution(int[] arr1, int[] arr2) {
        int sumArr1 = Arrays.stream(arr1).sum();
        int sumArr2 = Arrays.stream(arr2).sum();
        if (arr1.length > arr2.length)
            return 1;
        if (arr1.length < arr2.length)
            return -1;
        if (sumArr1 > sumArr2)
            return 1;
        if (sumArr1 < sumArr2)
            return -1;
        return 0;
        /*
        int answer = Integer.compare(arr1.length, arr2.length);

        if(answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
        * */
    }

}
