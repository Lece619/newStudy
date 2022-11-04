/*
https://school.programmers.co.kr/learn/courses/30/lessons/134240
        연습문제
        푸드 파이트 대회
*/
package normal2;

public class FoodFighter {
    public String solution(int[] food) {

        return makeFull(food);
    }

    private StringBuilder makeHalf( int[] food) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            sb.append(String.valueOf(i).repeat(food[i]/2));
        }
        return sb;
    }

    private String makeFull(int[] food) {

        StringBuilder result = new StringBuilder();
        StringBuilder sb = makeHalf( food );

        result.append(sb).append(0).append(sb.reverse());

        return result.toString();
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        FoodFighter foodFighter = new FoodFighter();
        String solution = foodFighter.solution(food);
        System.out.println("solution = " + solution);
    }
}
