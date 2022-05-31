package normal;

public class ChangeStringToIn {
    public int solution(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return Integer.parseInt(s.substring(1))*(-1);
        }
    }
}
