package basic8;

public class DiceGame {

    public int solution(int a, int b) {

        if((a & 0b01) == 1 & (b & 0b01) == 1)
            return a * a + b * b;

        if((a & 0b01) == 1 || (b & 0b01) == 1)
            return 2 * ( a * b);

        return a - b;
    }
}
