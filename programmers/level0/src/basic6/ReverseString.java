package basic6;

public class ReverseString {
    public String solution(String my_string, int s, int e) {
        StringBuilder reverse = new StringBuilder(my_string.substring(s, e + 1)).reverse();
        return my_string.substring(0, s) + reverse + my_string.substring(e + 1);
    }
}
