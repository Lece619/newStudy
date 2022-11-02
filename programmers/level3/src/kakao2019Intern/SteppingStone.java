/*
https://school.programmers.co.kr/learn/courses/30/lessons/64062
        2019 카카오 개발자 겨울 인턴십
        징검다리 건너기
*/

package kakao2019Intern;

public class SteppingStone {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int max = 200_000_000;
        int min = 1;

        while( min < max ) {

            int center = ( min + max ) / 2;

            if(isCanStep(stones, k, center)){
                min = center + 1;
                answer = center;
            }else{
                max = center;
            }

        }
        return answer;
    }

    private boolean isCanStep(int[] stones, int k, int people) {

        int dist = 0;

        for (int i = 0; i < stones.length; i++) {
            int check = stones[i] - people;
            if(check >= 0){
                dist = 0;
            }else{
                dist++;
            }

            if(dist >= k){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int arr = 200_000_000;
        System.out.println("arr = " + arr);
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        SteppingStone steppingStone = new SteppingStone();
        int solution = steppingStone.solution(stones, k);
        System.out.println("solution = " + solution);
    }

}
