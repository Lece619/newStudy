import java.util.*;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        arrayList.add("2");
        System.out.println(arrayList);
        arrayList.remove("3");
        System.out.println(arrayList);
    }
}
