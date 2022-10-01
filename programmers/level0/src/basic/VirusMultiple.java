package basic;

public class VirusMultiple {
    public int solution(int n, int t) {
        double sqrt = Math.sqrt(n);
        //정수판별
        boolean find = sqrt % 1 == 0;
        System.out.println("find = " + find);
        return (int)(n * Math.pow(2, 10));
    }

    public static void main(String[] args) {
        VirusMultiple virusMultiple = new VirusMultiple();
        int solution = virusMultiple.solution(2, 10);
        System.out.println("solution = " + solution);
    }
}
