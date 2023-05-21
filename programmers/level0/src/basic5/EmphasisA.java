package basic5;

import java.util.stream.Collectors;

public class EmphasisA {
    public String solution(String myString) {
        return myString.toLowerCase().chars()
                .mapToObj(i->(char)i == 'a' ? "A" : String.valueOf((char)i))
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        EmphasisA emphasisA = new EmphasisA();
        System.out.println(emphasisA.solution("BANANA"));
    }
}
