package basic3;

public class FindInteger {
    public int solution(String my_string) {
        int answer = 0;
        int sum = my_string.chars().filter(Character::isDigit).mapToObj(i -> Integer.parseInt(String.valueOf((char) i))).mapToInt(i -> i).sum();
        return answer;
    }
}
