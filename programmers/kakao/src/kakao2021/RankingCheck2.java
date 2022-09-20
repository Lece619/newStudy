/*
https://school.programmers.co.kr/learn/courses/30/lessons/72412
2021 KAKAO BLIND RECRUITMENT
        순위 검색
*/
package kakao2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RankingCheck2 {
//    public static String[] language = {"java", "python", "cpp"};
//    public static String[] position = {"frontend", "backend"};
//    public static String[] level = {"junior", "senior"};
//    public static String[] food = {"chicken", "pizza"};
    HashMap<String, ArrayList<Integer>> scores = new HashMap<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        int idx = 0;
        makeScores(info);
        for (String s : scores.keySet()) {
            Collections.sort(scores.get(s));
        }

        for (String s : query) {
            int count = 0;
            String[] nowQuery = s.replaceAll(" and", "").split(" ");
            int score = Integer.parseInt(nowQuery[4]);
            for (String mainKey : scores.keySet()) {
                boolean check = true;

                for (int i = 0; i < nowQuery.length - 1; i++) {
                    String keyWord = nowQuery[i];
                    if (!mainKey.contains(keyWord)) {
                        check = false;
                        break;
                    }
                }

                if(check){
//                    count += scores.get(mainKey).stream().filter(i -> i >= score).count();
                    count += findCount(scores.get(mainKey), score);
                }
            }
            answer[idx++] = count;
        }

        return answer;
    }

    private int findCount(ArrayList<Integer> arrayList, int score) {
        int count = arrayList.size();
        int min = 0 ;
        int max = count;

        while(min < max){
            int mid = (max + min) / 2 ;
            if(arrayList.get(mid) >= score){
                max = mid;
            }else{
                min = mid + 1;
            }
        }

        return count-min;
    }

    private void makeScores(String[] info) {
        for (String s : info) {
            String[] s1 = s.split(" ");
            StringBuilder sb = new StringBuilder();
            String key =
                    sb.append(s1[0]).append(s1[1]).append(s1[2]).append(s1[3]).append(" -").toString();
            int score = Integer.parseInt(s1[4]);
            if(!scores.containsKey(key)) {
                scores.put(key,new ArrayList<>());
            }
                scores.get(key).add(score);
        }
    }


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println("info.length = " + info.length);
        System.out.println("query = " + query.length);
        int[] answer = new RankingCheck2().solution(info, query);
        for (int i : answer) {
            System.out.println("i = " + i);
        }
        //target Answer {1,1,1,1,2,4}

    }
}
