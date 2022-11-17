/*
https://school.programmers.co.kr/learn/courses/30/lessons/136798
        연습문제
        기사단원의 무기
*/

package normal2;

public class KnightsWeapon {

    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i < number + 1; i++) {
            answer += needSteel(i, limit, power);
        }

        return answer;
    }

    private int needSteel(int num, int limit, int power) {
        int result= 0;
        double sqrt = Math.sqrt(num);
        for (int i = 1; i < sqrt; i++) {
            if(num % i == 0){
                result++;
            }
        }
        result *= 2;
        if(num % sqrt == 0){
            result++;
        }
        if(result > limit){
            return power;
        }
        return result;
    }


    public static void main(String[] args) {

        int number = 5;
        int limit = 3;
        int power = 2;

        KnightsWeapon knightsWeapon = new KnightsWeapon();

        int solution = knightsWeapon.solution(number, limit, power);

        System.out.println("solution = " + solution);
    }
}
