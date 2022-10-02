package basic;

import java.util.Arrays;

public class StreamArr {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        int[] ints = Arrays.stream(numlist).filter(a -> a % n == 0).toArray();
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
        return answer;
    }
    public static void main(String[] args) {
        StreamArr streamArr = new StreamArr();
        streamArr.solution(3,new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});
    }
}
