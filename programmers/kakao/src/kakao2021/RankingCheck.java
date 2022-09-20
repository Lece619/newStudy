/*
https://school.programmers.co.kr/learn/courses/30/lessons/72412
2021 KAKAO BLIND RECRUITMENT
        순위 검색
*/
package kakao2021;

import java.util.ArrayList;
import java.util.HashMap;

public class RankingCheck {

    HashMap<String, ArrayList<Integer>> scores = new HashMap<>();


    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        for (String s : info) {
            String[] check = s.split(" ");
            String key = check[0] + check[1] + check[2] + check[3];
            int score = Integer.parseInt(check[4]);
            if(!scores.containsKey((key))){
                scores.put(key, new ArrayList<>());
            }
            scores.get(key).add(score);
        }
        int idx = 0;
        for (String s : query) {
            String[] q = s.replaceAll(" and","").replaceAll("-", "[a-zA-Z]{1,}").split(" ");
            String key = q[0] + q[1] + q[2] + q[3];
            int score = Integer.parseInt(q[4]);
            int answerNum = 0;
            for (String s1 : scores.keySet()) {
                if(s1.matches(key)){
                    answerNum += scores.get(s1).stream().filter(i-> i >= score).count();
                }
            }
            answer[idx++] = answerNum;
        }

        return answer;
    }



    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println("info.length = " + info.length);
        System.out.println("query = " + query.length);
        int[] answer = new RankingCheck().solution(info, query);
        for (int i : answer) {
            System.out.println("i = " + i);
        }
        //target Answer {1,1,1,1,2,4}

    }
}
