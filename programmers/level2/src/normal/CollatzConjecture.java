/*
https://school.programmers.co.kr/learn/courses/30/lessons/134239
        연습문제
        우박수열 정적분
*/

package normal;

import java.util.ArrayList;

public class CollatzConjecture {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Integer> graph = new ArrayList<>();
        ArrayList<Double> areas = new ArrayList<>();
        graph.add(k);

        do {
            double area = k;

            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }

            area += k;
            areas.add(area / 2);
            graph.add(k);

        } while (k != 1);

        int endPoint = graph.size() - 1;
        for (int i = 0; i < answer.length; i++) {
            int start = ranges[i][0];
            int end = endPoint + ranges[i][1];

            if(isDisable(start, end, endPoint)){
                answer[i] = -1.0;
                continue;
            }

            answer[i] = makeArea(areas, start, end);
        }

        return answer;
    }

    private double makeArea(ArrayList<Double> areas, int start, int end) {
        double result = 0.0;

        for (int i = start; i < end; i++) {
             result += areas.get(i);
        }
        return result;
    }

    private boolean isDisable(int start, int end, int endPoint) {

        if(start > end){
            return true;
        }
        if(start < 0 || start > endPoint) {
            return true;
        }
        if(end < 0 || end > endPoint) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int k = 5;
        int[][] range = {{0,0}, {0,-1}, {2,-3}, {3,-3}};

        CollatzConjecture collatzConjecture = new CollatzConjecture();
        double[] solution = collatzConjecture.solution(k, range);
        for (double v : solution) {
            System.out.println("v = " + v);
        }

    }
}
