package basic5;

import java.util.Scanner;

public class StringRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        a.chars().mapToObj(i->String.valueOf((char)i)).forEach(System.out::println);
    }
}
