package kakao2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Report1 {
    public static void main(String[] args) {
        String[] id_list ={"muzi", "frodo", "apeach", "neo"};
        String[] report ={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = new Solution1().solution(id_list,report,k);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

}
class Solution1 {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashSet<String> set = new HashSet<>(Arrays.asList(report));
        int[] isReported= new int[id_list.length];
        int[] answer = new int[id_list.length];
        HashMap<String,Integer> answerMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            answerMap.put(id_list[i],i);
        }
        HashMap<String, String> map = new HashMap<>();
        String[] strings = set.toArray(new String[0]);
        for (String s : set) {
            String[] str = s.split(" ");
            map.put(str[1],map.getOrDefault(str[1],"")+str[0]+" ");
        }
        for (String value : map.values()) {
            String[] str = value.split(" ");
            if(str.length>=k){
                for (int i = 0; i < str.length; i++) {
                    answer[answerMap.get(str[i])]++;
                }
            }
        }
        return answer;
    }
}
