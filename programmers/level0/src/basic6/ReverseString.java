package basic6;

public class ReverseString {
    public String solution(String my_string, int s, int e) {
        StringBuilder reverse = new StringBuilder(my_string.substring(s, e + 1)).reverse();
        return my_string.substring(0, s) + reverse + my_string.substring(e + 1);
    }
    public String solution(String my_string, int[][] queries) {
        String answer = my_string;
        for (int[] query : queries) {
            answer = solution(answer, query[0], query[1]);
        }
        return answer;
    }
}
