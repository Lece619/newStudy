package basic3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingBy {
    public int solution(int[] array) {

        Map<Integer, Long> collect = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        Map<Integer, Long> collect2 = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        System.out.println("collect = " + collect);
        System.out.println("collect2 = " + collect2);
        Long max = collect.entrySet().stream().max(Comparator.comparing(i -> i.getValue())).get().getValue();
        long count = collect.entrySet().stream().filter(i -> i.getValue() == max).count();

        if(count!=1){
            return -1;
        }

        return collect.entrySet().stream().filter(i -> i.getValue() == max).findFirst().get().getKey();
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 4};
        GroupingBy groupingBy = new GroupingBy();
        int solution = groupingBy.solution(array);
        System.out.println("solution = " + solution);
    }
}
