package kakao2022;

import dev_matching2021.*;

import java.util.Arrays;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/92334
public class Report {


    public static void main(String[] args) {
        String[] id_list ={"con", "ryan" };
        String[] report ={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = new Solution().solution(id_list,report,k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] isReported = new int[id_list.length];
        HashSet<String> set =new HashSet<String>(Arrays.asList(report));
        for (String s : set) {
            String[] str = s.split(" ");
            for (int i = 0; i < id_list.length; i++) {
                if(str[1].equals(id_list[i])){
                    isReported[i]++;
                }
            }
        }
        for (int i = 0; i < isReported.length; i++) {
            if(isReported[i]>=k){
                for (String s : set) {
                    String[] str = s.split(" ");
                    if(str[1].equals(id_list[i])){
                        for (int j = 0; j < id_list.length; j++) {
                            if(id_list[j].equals(str[0])){
                                answer[j]++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}