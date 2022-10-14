package basic2;

public class BinarySum {
    public String solution(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }
    public static void main(String[] args) {
        BinarySum binarySum = new BinarySum();
        System.out.println("binarySum.solution(\"10\", \"11\") = " + binarySum.solution("10", "11"));
    }
}
