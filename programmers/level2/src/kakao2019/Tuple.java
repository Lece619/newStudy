//https://programmers.co.kr/learn/courses/30/lessons/64065?language=java
//        코딩테스트 연습
//        2019 카카오 개발자 겨울 인턴십
//        튜플
package kakao2019;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Tuple {
    public int[] solution(String s) {
        s = s.replaceAll("^[{]|[}]$","");
        s = s.replaceAll("^[{]|[}]$","");
        String[] sArr = s.split("[}]+[,]+[{]");
        HashMap<Integer,String> map = new HashMap<>();
        for (int i = 0; i < sArr.length; i++) {
            map.put(sArr[i].length(),sArr[i]);
        }
        System.out.println(map);
        return null;
    }

    public static void main(String[] args) {
        String sample = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        sample = sample.replaceAll("^[{]|[}]$","");
        sample = sample.replaceAll("^[{]|[}]$","");
       // sample = sample.replaceAll("[}]+[,]+[{]"," ");
        //String[] sArr = sample.split("[}]+[,]+[{]");
        System.out.println(sample);
        new Tuple().solution(sample);
    }
}
