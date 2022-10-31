/*
https://school.programmers.co.kr/learn/courses/30/lessons/133500
        연습문제
        등대
*/

package normal;


import java.util.Arrays;

public class LightHouse2 {
    int answer = 0;
    public int solution(int n, int[][] lighthouse) {

        int[] lights = new int[n+1];
        boolean[] onLight = new boolean[n+1];

        while(makeLight(lighthouse, lights, onLight) != 0){
            ;
        }
        return answer;
    }

    private int makeLight(int[][] lighthouse, int[] lights, boolean[] onLight) {
        int max = 0;

        Arrays.fill(lights, 0);
        lights[0] = -1;

        for (int[] light : lighthouse) {
            if(!onLight[light[0]] && !onLight[light[1]]){
                lights[light[0]]++;
                lights[light[1]]++;
                max = Math.max(lights[light[0]], max);
                max = Math.max(lights[light[1]], max);
            }
        }

        if(max==0){
            return max;
        }
        for (int i = 0; i < lights.length; i++) {
            if(lights[i] == max){
                onLight[i] = true;
                answer++;
                break;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        LightHouse2 lightHouse = new LightHouse2();
        int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        int solution = lightHouse.solution(n, lighthouse);
        System.out.println("solution = " + solution);
    }
}
