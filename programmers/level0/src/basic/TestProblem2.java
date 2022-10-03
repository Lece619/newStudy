package basic;

public class TestProblem2 {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if(i == num1){
                sb.append(my_string.charAt(num2));
            }else if(i == num2){
                sb.append(my_string.charAt(num1));
            }else{
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }

    public int solution(int n) {
        int i;
        for( i = 1 ; i <= 10; i++){
            System.out.println("i = " + i);
            System.out.println("facc(i) = " + facc(i));
            System.out.println("facc = " + (facc(n) > n));
            System.out.println("n = " + n);
            if(facc(n) > n){
                break;
            }
        }
        return i;
    }

    public int facc(int n){
        if(n==1 || n==0){
            return 1;
        }else{
            return n * facc(n-1);
        }
    }
    public int solution2(int price) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        TestProblem2 testProblem2 = new TestProblem2();
        int solution = testProblem2.solution(10);
        System.out.println("solution = " + solution);
    }
}
