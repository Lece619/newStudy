package basic4;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MaxMultiple {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length-1] * numbers[numbers.length-2];
    }
    public String solution(String my_string, String letter) {
        return my_string.chars().filter(i->(char)i != letter.charAt(0)).mapToObj(i->String.valueOf((char)i)).collect(Collectors.joining());
    }
}
