//https://programmers.co.kr/learn/courses/30/lessons/72412
//        코딩테스트 연습
//        2021 KAKAO BLIND RECRUITMENT
//        순위 검색
package kakao2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SearchRanking {
    public static String[] language = {"java", "python", "cpp"};
    public static String[] position = {"frontend", "backend"};
    public static String[] level = {"junior", "senior"};
    public static String[] food = {"chicken", "pizza"};
    public static HashMap<String, ArrayList<Integer>> applicant;

    public Integer[] solution(String[] info, String[] query) {
        applicant = new HashMap<>();
        //초기화
        for (int i = 0; i < language.length; i++) {
            for (int j = 0; j < position.length; j++) {
                for (int k = 0; k < level.length; k++) {
                    for (int l = 0; l < food.length; l++) {
                        applicant.put(language[i] + " " +
                                position[j] + " " +
                                level[k] + " " + food[l], new ArrayList<>());
                    }
                }
            }
        }
        //지원자 정보 삽입
        makeMap(info);
        ArrayList<Integer> answerList = new ArrayList<>();
        for (String s : query) {
            String[] queryArr = s.replaceAll("[ ]+[a]+[n]+[d]","").split(" ");
            ArrayList<String> keys = makeKey(queryArr[0], queryArr[1], queryArr[2], queryArr[3]);
            int score = Integer.parseInt(queryArr[4]);
            int count = 0;
            for (String key : keys) {
                //count += applicant.get(key).stream().filter(i -> i>=score).count();
                Collections.sort(applicant.get(key),Collections.reverseOrder());
                for (int i = 0; i < applicant.get(key).size(); i++) {
                    if(applicant.get(key).get(i) < score){
                        break;
                    }
                    count++;
                }
            }
            answerList.add(count);
        }
        System.out.println(answerList);
        Integer[] answer = answerList.toArray(new Integer[0]);
        return answer;
    }
    
    //map에 넣어주기
    public static void makeMap(String[] info) {
        for (String s : info) {
            String[] arrString = s.split(" ");
            applicant.get(arrString[0] + " " + arrString[1] + " " +
                    arrString[2] + " " + arrString[3]).add(Integer.parseInt(arrString[4]));
        }
    }

    public static ArrayList<String> makeKey(String lang, String pos, String lev, String fo){
        ArrayList<String> keys = new ArrayList<>();

        for (int i = 0; i < language.length; i++) {
            if(!(lang.equals("-") || language[i].equals(lang)))
                continue;
            for (int j = 0; j < position.length; j++) {
                if(!(pos.equals("-")||position[j].equals(pos)))
                    continue;
                for (int k = 0; k < level.length; k++) {
                    if(!(lev.equals("-")||level[k].equals(lev)))
                        continue;
                    for (int l = 0; l < food.length; l++) {
                        if(fo.equals("-") || food[l].equals(fo))
                            keys.add(language[i] + " " +
                                    position[j] + " " +
                                    level[k] + " " + food[l]);
                    }
                }
            }
        }

        return keys;
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

        System.out.println(makeKey(query01[0],query01[1],query01[2],query01[3]));

        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        map.put(""+1+2+3,new ArrayList<>());
        map.get(""+1+2+3).add(30);
        map.get(""+1+2+3).add(40);
        map.get(""+1+2+3).add(50);
        long count = map.get(""+1+2+3).stream().filter(a->a>40).count();
        System.out.println(count);

        new SearchRanking().solution(info,query);
        System.out.println(applicant);
        //System.out.println(map.get("123"));
    }
}
