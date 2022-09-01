/*
https://school.programmers.co.kr/learn/courses/30/lessons/12980
        코딩테스트 연습
        Summer/Winter Coding(~2018)
        점프와 순간 이동
*/
package seasoncoding;

public class JumpAndTeleportation {

        public int solution(int n) {
                return findStep(n);
        }

        private int findStep(int n) {
                if(n == 0){
                        return 0;
                }
                else if(n % 2 == 0){
                        return findStep(n/2);
                }else{
                        return findStep((n-1) / 2) + 1;
                }
        }

        public static void main(String[] args) {
                JumpAndTeleportation test = new JumpAndTeleportation();
                int solution = test.solution(5000);
                System.out.println("solution = " + solution);
        }
}
