package basic5;

public class FindChangedString {
    public int solution(String myString, String pat) {
        String replace = pat.replace("A", "C").replace("B", "A").replace("C", "B");
        return myString.contains(replace) ? 1 : 0;
    }
}
