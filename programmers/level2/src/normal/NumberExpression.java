//https://programmers.co.kr/learn/courses/30/lessons/12924?language=java 숫자의 표현
package normal;

public class NumberExpression {
        public int solution(int n) {
            int answer = 0;
            for (int i = 1; i < n; i++) {
                if(n%i==0){
                    if(i%2!=0) {
                        answer++;
                    }
                }
            }
            if(n%2!=0){
                answer++;
            }
            //8 약수를 구하고 그 약수가 홀수면 가능.

            return answer;
        }
}
