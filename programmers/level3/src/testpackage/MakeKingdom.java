package testpackage;

import java.util.*;

public class MakeKingdom {

    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long result = 0;
        long answer = 0;
        HashMap<Integer, Double> good = new HashMap<>();
        for (int i = 0; i < w.length; i++) {
            good.put(i, ((double) w[i]/t[i]));
        }
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(good.entrySet());
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        for (Map.Entry<Integer, Double> entry : list) {
            int idx = entry.getKey();
            int nowGold = g[idx];
            int nowSilver = s[idx];

            while(true) {
                if (nowGold == 0 && nowSilver == 0){
                    break;
                }
                if ( a == 0 && b == 0){
                    break;
                }
                if( a * nowGold == 0 && b * nowSilver == 0){
                    break;
                }

                int weight = w[idx];
                int moveGold = Math.min(weight, nowGold);

                if(nowGold != 0) {
                    weight -= Math.min(weight, nowGold);

                    int minA = Math.min(a, moveGold);
                    a -= minA;
                    nowGold -= minA;

                    if (a == 0) {
                        nowGold = 0;
                        weight = moveGold - minA;
                    }

                }

                int moveSilver = Math.min(weight, nowSilver);
                weight -= Math.min(weight, nowSilver);

                int minB = Math.min(b, moveSilver);
                b -= minB;
                nowSilver -= minB;
                
                answer += t[idx];
                if (nowGold == 0 && nowSilver == 0){
                    break;
                }
                if ( a == 0 && b == 0){
                    break;
                }
                if( a * nowGold == 0 && b * nowSilver == 0){
                    break;
                }

                answer += t[idx];
            
            }
            result = Math.max(answer, result);
            answer = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        MakeKingdom makeKingdom = new MakeKingdom();
        int a = 90;
        int b = 500;
        int[] g = {70,70,0};
        int[] s = {0,0,500};
        int[] w = {100,100,2};
        int[] t = {4,8,1};

        System.out.println("solution " + makeKingdom.solution(a, b, g, s, w, t));
    }
}
