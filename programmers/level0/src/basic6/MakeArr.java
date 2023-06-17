package basic6;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MakeArr {

    Stack<Integer> fiveAndZero = new Stack<>();
    StringBuilder stringBuilder = new StringBuilder();
    public int[] solution(int l, int r) {

        int length = String.valueOf(r).length();
        makeStack(0, length, l, r);
        int[] answer = fiveAndZero.stream().collect(Collectors.toList()).stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);

        return answer.length == 0 ? new int[]{-1} : answer;
    }

    private void makeStack(int index, int length, int l, int r) {
        if(index == length){
            int result = Integer.parseInt(stringBuilder.toString());
            if(result >= l && result <= r){
                fiveAndZero.push(result);
            }
            return;
        }


        stringBuilder.append("0");
        makeStack(index + 1, length, l, r);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

        stringBuilder.append("5");
        makeStack(index + 1, length, l, r);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);

    }

    public static void main(String[] args) {
        MakeArr makeArr = new MakeArr();
        makeArr.solution(5, 555);
    }
}
