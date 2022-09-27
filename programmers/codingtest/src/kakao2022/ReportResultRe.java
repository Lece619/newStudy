/*
https://school.programmers.co.kr/learn/courses/30/lessons/92334
        2022 KAKAO BLIND RECRUITMENT
        신고 결과 받기
*/

package kakao2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReportResultRe {

    HashMap<String, Integer> reportedCount = new HashMap<>();
    HashSet<String> repostSet;
    HashMap<String, Integer> getMail = new HashMap<>();


    public int[] solution(String[] id_list, String[] report, int k){

        int[] answer = new int[id_list.length];
        repostSet = new HashSet<>(Arrays.asList(report));

        for (String s : repostSet) {
            String reportedKey = s.split(" ")[1];
            reportedCount.put(reportedKey, reportedCount.getOrDefault(reportedKey,0)+1);
        }

        for (String s : repostSet) {
            String[] reportedKey = s.split(" ");
            if(reportedCount.getOrDefault(reportedKey[1],0)>=k){
                getMail.put(reportedKey[0], getMail.getOrDefault(reportedKey[0],0) + 1);
            }
        }

        List<String> strings = Arrays.asList(id_list);
        for (int i = 0; i < strings.size(); i++) {
            answer[i] = getMail.getOrDefault(strings.get(i),0);
        }
        
        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        int[] answer = new ReportResultRe().solution(id_list, report, k);

        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
