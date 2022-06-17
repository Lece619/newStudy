//https://programmers.co.kr/learn/courses/30/lessons/12985
//코딩테스트 연습
//2017 팁스타운
//예상 대진표

package tipstown2017;

public class ExpectedDraw {

    public int solution(int n, int a, int b) {
        int answer = 0;
        a--;
        b--;
        for (int i = 1; i <= n; i++) {
            a /= 2;
            b /= 2;
            if(a==b){
                return i;
            }
        }
        return answer;
    }
}
