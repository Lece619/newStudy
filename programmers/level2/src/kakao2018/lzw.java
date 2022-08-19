/*
https://school.programmers.co.kr/learn/courses/30/lessons/17684
코딩테스트 연습 2018 KAKAO BLIND RECRUITMENT [3차] 압축
*/


        package kakao2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lzw {
    public int[] solution(String msg) {
        Map<String,Integer> lzw = new HashMap<>();
        List<String> answerList = new ArrayList<>();

        Integer key = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            lzw.put((char)i+"",key++);
        }

        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
//            System.out.println("i = " + i);
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                String check = sb.toString();
                if(!answerList.contains(check)){
                    if(!lzw.containsKey(check)){
                        i = j-1;
                        lzw.put(check,key++);
                        answerList.add(sb.deleteCharAt(sb.length()-1).toString());
                        break;
                    }else if(j== msg.length()-1){
                        answerList.add(check);
                        i = j+1;
                    }
                }else{
                    if(j==msg.length()-1){
                        answerList.add(check);
                        i = j+1;
                        break;
                    }
                }
            }
        }
//        System.out.println("lzw = " + lzw);
//        System.out.println("answerList = " + answerList);

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = lzw.get(answerList.get(i));
        }
        return answer;
    }

    public static void main(String[] args) {
        String msg = "THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATI" +
                "SISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS";
//        msg = "KAKAO";
        int[] a = new lzw().solution(msg);
        for (int i : a) {
            System.out.println("i = " + i);
        }
    }
}
