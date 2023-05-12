package basic5;

public class IsPreFix {
    public int solution(String my_string, String is_prefix) {
//        return my_string.contains(is_prefix) ? my_string.indexOf(is_prefix) == 0 ? 1 : 0 : 0;
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }
}
