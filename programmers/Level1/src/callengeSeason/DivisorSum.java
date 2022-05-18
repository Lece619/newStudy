package callengeSeason;

public class DivisorSum {
    public static void main(String[] args) {
    }
    public class Solution {

        //제곱수면 약수의 갯수는 홀수 ..
        //4 -> 1 2 4
        //16 -> 약수갯수  1 2 4 8 16  4->약수갯수 1 2 4 겹치는부분까지 4*4
        /*for (int i=left;i<=right;i++) {
            //제곱수인 경우 약수의 개수가 홀수
            if (i % Math.sqrt(i) == 0) {
                answer -= i;
            }
            //제곱수가 아닌 경우 약수의 개수가 짝수
            else {
                answer += i;
            }
        }*/

        public int solution(int left, int right) {
            int answer = 0;
            for(int i = left; i <= right;i++){
                answer+=i*(checkDivisor(i));
            }
            return answer;
        }
        public int checkDivisor(int num){
            int cnt = 0;
            for(int i= 1;i <= num;i++){
                if(num%i==0){
                    cnt++;
                }
            }
            return (cnt % 2 == 0) ? 1 : -1;
        }
    }
}
