//https://programmers.co.kr/learn/courses/30/lessons/72412
//        코딩테스트 연습
//        2021 KAKAO BLIND RECRUITMENT
//        순위 검색  -- 시간초과로 재코딩
package kakao2021;

import java.util.*;

public class SearchRanking2 {
    public static String[] language = {"java", "python", "cpp"};
    public static String[] position = {"frontend", "backend"};
    public static String[] level = {"junior", "senior"};
    public static String[] food = {"chicken", "pizza"};
    public static HashMap<HashSet<String>, ArrayList<Integer>> applicant;
    public Integer[] solution(String[] info, String[] query) {
        applicant = new HashMap<>();
        //초기화
        for (int i = 0; i < language.length; i++) {
            for (int j = 0; j < position.length; j++) {
                for (int k = 0; k < level.length; k++) {
                    for (int l = 0; l < food.length; l++) {
                        HashSet<String> keys = new HashSet<>();
                        keys.add(language[i]);
                        keys.add(position[j]);
                        keys.add(level[k]);
                        keys.add(food[l]);
                        keys.add("-");
                        applicant.put(keys, new ArrayList<>());
                    }
                }
            }
        }
        //지원자 정보 삽입
        makeMap(info);

        ArrayList<Integer> answerList = new ArrayList<>();
        for (String queryString : query) {
            int count = 0;
            String[] queryArr = queryString.replaceAll("[ ]+[a]+[n]+[d]","").split(" ");
            int score = Integer.parseInt(queryArr[4]);
            HashSet<String> key = new HashSet<>(Arrays.asList(queryArr).subList(0,4));
            for (HashSet<String> strings : applicant.keySet()) {
                if(strings.containsAll(key)) {
                    count += applicant.get(strings).stream().filter(i->i>=score).count();
                }
            }
            answerList.add(count);
        }
        System.out.println(answerList);
        Integer[] answer = answerList.toArray(new Integer[0]);
        return answer;
    }

    public static void makeMap(String[] info) {
        for (String s : info) {
            String[] arrString = s.split(" ");
            HashSet<String> keys = new HashSet<>(Arrays.asList(arrString).subList(0,4));

            for (HashSet<String> strings : applicant.keySet()) {
                if(strings.containsAll(keys)){
                    applicant.get(strings).add(Integer.parseInt(arrString[4]));
                }
            }
        }
    }


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};
        String[] query= {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100","- and - and - and - 150"};

        String[] test1 = {"1","2","3"};
        String[] test2 = {"1","2","3"};
        String[] query01 = query[1].replaceAll("[ ]+[a]+[n]+[d]","").split(" ");


        System.out.println(info[0].replaceAll("[\\d]","").trim());
        HashMap<Set<String>, ArrayList<Integer>> map = new HashMap<>();
        Set<String> key = new HashSet<>();
        key.add("pizza");
        key.add("python");
        map.put(key,new ArrayList<>());
        for (Set<String> strings : map.keySet()) {
            Set<String> set = new HashSet<>();
            set.add("pizza");
            if(strings.containsAll(set)){
                System.out.println("ok");
            }
            set.add("pizza2");
            if(strings.containsAll(set)){
                System.out.println("ok");
            }
        }
        new SearchRanking2().solution(info,query);
        System.out.println(applicant);
        //System.out.println(map.get("123"));
    }
}
