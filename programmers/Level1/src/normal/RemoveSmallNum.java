package normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RemoveSmallNum {
    public static void main(String[] args) {
        new RemoveSmallNum().solution(new int[]{4,3,2,1});
    }

    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            System.out.println(i);
            list.add(i);
        }
        list.remove(Collections.min(list));
        System.out.println(list);
        if(list.isEmpty()){
            return new int[]{-1};
        }else{
            int[] answer = new int[list.size()];
            for (int i = 0; i < arr.length-1; i++) {
                answer[i]=list.get(i);
            }
            return answer;
        }
    }
}
