package kakao2019;

import java.util.*;

public class FailureLate {
    public static void main(String[] args) {
        int N=5;
        int[] stages={2, 1, 2, 6, 2, 4, 3, 3};
        new Solution().solution(N,stages);
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {

        int[] total = new int[N+2];
        int[] fail = new int[N+2];
        for (int stage : stages) {
            fail[stage]++;
            for(int i = 1;i <= stage;i++){
                total[i]++;
            }
        }
        double[] temp = new double[N];
        HashMap<Integer,Double> rateMap = new HashMap<>();
        for (int i = 1; i < N+1; i++) {
            System.out.println(fail[i]+ "  "+total[i]);
            if(total[i]==0||fail[i]==0){
                rateMap.put(i,0.0);
            }else{
                rateMap.put(i,(((double)fail[i]/total[i])));
            }
        }
        List<Map .Entry<Integer,Double>> entryList = new LinkedList<>(rateMap.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Map.Entry<Integer, Double> o1, Map.Entry<Integer, Double> o2) {
                    if((o2.getValue()-o1.getValue())==0){
                        return o1.getKey()-o2.getKey();
                    }
                    if(o2.getValue()-o1.getValue()>=0)
                        return 1;
                    else{
                        return -1;
                    }
            }
        });
        int[] answer = new int[N];
        int cnt=0;
        for(Map.Entry<Integer,Double> entry : entryList){
            answer[cnt]=entry.getKey();
            cnt++;/*
            System.out.println();
            System.out.println(cnt+" "+ entry.getKey()+"  "+ entry.getValue());*/
        }
        return answer;
    }
}