package basic;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingBy {
    public String solution(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            String replace = s.replace(s.charAt(i) + "", "");
            if(s.length() - replace.length() == 1){
                set.add(s.charAt(i)+"");
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
//다른방식풀기

        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        System.out.println("collect = " + collect);

        String collect1 = Arrays.stream(s.split("")).collect(Collectors.groupingBy(a -> a, Collectors.counting())).entrySet().stream()
                .filter(enter -> enter.getValue() == 1).map(entry -> entry.getKey()).sorted().collect(Collectors.joining());
        System.out.println("collect1 = " + collect1);

        return String.join("", list);
    }

    public static void main(String[] args) {
        GroupingBy groupingBy = new GroupingBy();
        System.out.println("groupingBy.solution(\"hello\") = " + groupingBy.solution("hello"));
    }
}
