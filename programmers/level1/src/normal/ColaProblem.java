package normal;

public class ColaProblem {

    public int solution(int a, int b, int n) {
        int answer = 0;

        while(n >= a){
            answer += n / a * b;
            n = n / a * b + n % a;
        }
        return answer;
    }

    public static void main(String[] args) {
        ColaProblem colaProblem = new ColaProblem();
        int solution = colaProblem.solution(2, 1, 20);
        System.out.println("solution = " + solution);

    }
}
