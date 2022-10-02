package basic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestProblem {
    public int solution(int num, int k) {

        int answer = 0;
        return answer;
    }

    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        HashSet<String> set = new HashSet<>(List.of(s1));
        for (String s : s2) {
            if(set.contains(s)){
                answer++;
            }
        }
        return answer;
    }

    public int solution(String my_string) {
        int answer = 0;
        String[] s = my_string.trim().split(" ");
        int oper = 1;
        for (String s1 : s) {
            if(s1.equals("+") || s1.equals("-")){
                oper = s1.equals("-") ? -1 : 1;
            }else {
                answer += Integer.parseInt(s1) * oper;
            }
        }
        return answer;
    }

    public int[] solution(int[] array) {
        int[] answer = new int[2];
        for (int i = 0; i < array.length; i++) {
            if(answer[0] < array[i]){
                answer[0] = array[i];
                answer[1] = i;
            }
        }
        return answer;
    }
    public int[] solution(int n) {
        int[] num = new int[n];
        Arrays.setAll(num, i -> i + 1);
//        return Arrays.stream(num).filter(i -> n % i == 0).toArray();
        return IntStream.rangeClosed(1,n).filter(i->i % n == 0).toArray();
    }
    public String solution2(String s) {
        HashSet<String> set = new HashSet<>();
        Map<String, Long> collect = Arrays.stream(s.split("")).collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        System.out.println("collect = " + collect);
        for (int i = 0; i < s.length(); i++) {
            String replace = s.replace(s.charAt(i) + "", "");
            if(s.length() - replace.length() == 1){
                set.add(s.charAt(i)+"");
            }
        }
        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return String.join("", list);
    }


    public static void main(String[] args) {
        int num = 3125682;
        int k = 2;
        TestProblem testProblem = new TestProblem();
        testProblem.solution(new String[]{"a", "b", "c"}, new String[]{"com", "b", "d", "p", "c"});
        System.out.println("testProblem.solution2(\"hello\") = " + testProblem.solution2("hello"));
    }
}
