//https://programmers.co.kr/learn/courses/30/lessons/64065?language=java
//        코딩테스트 연습
//        2019 카카오 개발자 겨울 인턴십
//        튜플
package kakao2019;

import java.util.ArrayList;
import java.util.HashMap;

public class Tuple {
    public int[] solution(String s) {
        s = s.replaceAll("^[{]|[}]$","");
        s = s.replaceAll("^[{]|[}]$","");
        String[] sArr = s.split("[}]+[,]+[{]");
        HashMap<Integer,String[]> map = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            //4,2,3 = > [4,2,3] 형태로
            String[] StringArr = sArr[i].split(",");
            map.put(StringArr.length,StringArr);
        }
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            System.out.println();
            System.out.println(map.get(i).length);
            for (String s1 : map.get(i)) {
                if(!ans.contains(s1)){
                    ans.add(s1);
                }
            }
        }
        int[] answer = ans.stream().mapToInt(Integer::parseInt).toArray();

        return answer;
    }

    public static void main(String[] args) {
        String sample = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

       // sample = sample.replaceAll("[}]+[,]+[{]"," ");
        //String[] sArr = sample.split("[}]+[,]+[{]");
        System.out.println(sample);
        String[] arr = sample.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        for (String s : arr) {
            System.out.println(s);
        }
       // new Tuple().solution(sample);
    }
}
