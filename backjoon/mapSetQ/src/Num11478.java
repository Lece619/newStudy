import java.util.HashSet;
import java.util.Scanner;

public class Num11478 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        HashSet<String> set = new HashSet<>();
        for (int i = 1; i < str.length()+1; i++) {
            int range = i;
            for (int j = 0; j < str.length()-i+1; j++) {
               // System.out.println(str.substring(j,j+range));
                set.add(str.substring(j,range+j));

            }
        }
        System.out.println(set.size());
    }
}

