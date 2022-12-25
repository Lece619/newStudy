package basic4;

public class ThrowBall {
    public int solution(int[] numbers, int k) {
        return numbers[ (k * 2) % numbers.length ];
    }

    public int solution(int n) {

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += findCom(i);
        }
        return answer;
    }

    private int findCom(int n) {
        int count = getCount(n);
        if( count >= 3){
            return 1;
        }
        return 0;
    }

    private int getCount(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(n % i == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ThrowBall throwBall = new ThrowBall();
        int solution = throwBall.solution(10);
        System.out.println("solution = " + solution);
    }
}
