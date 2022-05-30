//https://programmers.co.kr/learn/courses/30/lessons/12924?language=java 숫자의 표현
package normal;

public class NumberExpression {
    public int solution(int n) {
        int answer = 1;
        if(n==1 || n==2 ){
            return answer;
        }
        if(n%2!=0){
            answer++;
        }
        for (int i = 3; i < n; i++) {
            if(n%i==0){
                answer++;
            }
        }
        return answer;
    }
}
