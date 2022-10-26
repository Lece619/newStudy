package helponboard;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FrogString {

    public static String solution ( String word){

        word.chars().mapToObj(i -> {
                    char nowC = (char) i;
                    if (nowC >= 'a' && nowC <= 'z') {
                        nowC = (char) ('a' + 'z' - nowC);
                    }
                    if (nowC >= 'A' && nowC <= 'Z') {
                        nowC = (char) ('A' + 'Z' - nowC);
                    }
                    return String.valueOf(nowC);
                }
        ).collect(Collectors.joining());

        return "answer";
    }

    public static void main(String[] args) {
        String solution = FrogString.solution("I love u !!");
        System.out.println("solution = " + solution);
    }
}
