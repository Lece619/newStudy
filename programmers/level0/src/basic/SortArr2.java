package basic;


import java.util.stream.Collectors;

public class SortArr2 {
    public String solution(String my_string) {
        return   my_string.toLowerCase()
                .chars().mapToObj(c -> (char) c)
                .sorted().map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        SortArr2 sortArr2 = new SortArr2();
        System.out.println("sortArr2 = " + sortArr2.solution("Bcad"));
    }
}
