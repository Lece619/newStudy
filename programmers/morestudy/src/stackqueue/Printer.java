package stackqueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> print = Arrays.stream(priorities).boxed().collect(Collectors.toCollection(LinkedList::new));
        Arrays.sort(priorities);
        int length = priorities.length - 1;

        while(!print.isEmpty()){
            Integer nowPrint = print.poll();
            if(nowPrint == priorities[length - answer]){
                answer++;
                if(location == 0){
                    return answer;
                }
                location--;
                continue;
            }
            print.add(nowPrint);
            if(location == 0){
                location = length - answer;
                continue;
            }
            location --;
        }
        return answer;
    }
}
