package normal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DevidedNumArr {
class Solution {

    /*
    public int[] divisible(int[] array, int divisor) {
        //ret에 array에 포함된 정수중, divisor로 나누어 떨어지는 숫자를 순서대로 넣으세요.
        return Arrays.stream(array).filter(factor -> factor % divisor == 0).toArray();
    }*/
    public Stack<Integer> solution(int[] arr, int divisor) {
        Stack<Integer> arrayList = new Stack<>();
        for (int i : arr) {
            if(i%divisor==0) {
                arrayList.add(i);
            }
        }
        if(arrayList.isEmpty()){
            arrayList.add(-1);
        }
        int[] answer = {};
        Collections.sort(arrayList);
        return arrayList;
    }
}
}
