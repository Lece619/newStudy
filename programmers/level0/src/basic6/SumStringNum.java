package basic6;

public class SumStringNum {
    public int solution(String num_str) {
        return num_str.chars().map(Character::getNumericValue).sum();
    }
}
