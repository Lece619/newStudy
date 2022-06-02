import java.util.*;

public class Test {
    public static void main(String[] args) {
        char[] a = {'a','s','d'};
        String b= String.valueOf(a);
        System.out.println(b);
        HashSet<Integer> set = new HashSet<>();
        set.add(3);
        ArrayList<Integer> list = new ArrayList<>(set);
        HashMap<String,String> map = new HashMap<>();
        map.put("1","1");
        ArrayList<Object> list2 = new ArrayList<>((Collection) map);
        System.out.println(map);
        System.out.println(list2);

    }
}
