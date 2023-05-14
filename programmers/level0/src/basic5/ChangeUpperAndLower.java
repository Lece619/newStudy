package basic5;

import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeUpperAndLower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(word.chars().mapToObj(i -> {
            return Character.isUpperCase(i) ? String.valueOf((char)Character.toLowerCase(i)) : String.valueOf((char)Character.toUpperCase(i));
        }).collect(Collectors.joining()));
    }
}
