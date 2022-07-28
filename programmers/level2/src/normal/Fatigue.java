//https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=java
//코딩테스트 연습  완전탐색  피로도
package normal;

import java.util.ArrayList;

public class Fatigue {

    int dungeonsLen;
    ArrayList<Integer[]> routes;
    ArrayList<Integer> makeRoute;

    public int solution(int k, int[][] dungeons) {
        //던전 순서 만들기
        dungeonsLen = dungeons.length;
        routes = new ArrayList<>();
        makeRoute = new ArrayList<Integer>();
        makeArrayList(dungeonsLen);
        int max = 0;
        for (Integer[] route : routes) {
            max = Math.max(max,checkResult(k, route, dungeons));
        }

        System.out.println(max);
        return max;
    }

    private int checkResult(int k, Integer[] route, int[][] dungeons) {

        int result = 0;

        for (Integer integer : route) {
            //최소 필요
            if(k >= dungeons[integer][0] ){
                k -= dungeons[integer][1];

                if(k >= 0){
                    result++;
                }
                else{
                    break;
                }
            }
        }
        return result;
    }

    private void makeArrayList(int dungeonsLen) {
        if (makeRoute.size() == dungeonsLen) {
            Integer[] r = makeRoute.toArray(new Integer[dungeonsLen]);
            routes.add(r);
        } else {
            for (int i = 0; i < dungeonsLen; i++) {
                if (!makeRoute.contains(i)) {
                    makeRoute.add(i);
                    makeArrayList(dungeonsLen);
                    makeRoute.remove((Integer) i);
                }
            }
        }
    }


    public static void main(String[] args) {
        Fatigue test = new Fatigue();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        test.solution(k, dungeons);
    }
}
