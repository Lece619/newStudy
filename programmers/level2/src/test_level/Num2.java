package test_level;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Num2 {
    public List<Integer> solution(String msg) {
        Map<String,Integer> lzw = new HashMap<>();
        List<String> answerList = new ArrayList<>();

        Integer key = 1;
        for (int i = 'A'; i <= 'Z'; i++) {
            lzw.put((char)i+"",key++);
        }

        for (int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            boolean flag = true;
            for (int j = i; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if(flag && j==msg.length()-1){
                    i = j+1;
                    answerList.add(sb.toString());
                }
                if(lzw.containsKey(sb.toString())) {
                    if (!answerList.contains(sb.toString())) {
                        answerList.add(sb.toString());
                        flag = false;
                    }
                }else{
                    lzw.put(sb.toString(),key++);
                    i = j-1;
                    if(flag){
                        answerList.add(sb.deleteCharAt(sb.length()-1).toString());
                        flag = false;
                    }
                    break;
                }
            }
        }
        System.out.println("msg = " + msg);
        System.out.println("answerList = " + answerList);
        System.out.println("lzw = " + lzw);
        List<Integer> collect = answerList.stream().map(a -> lzw.get(a)).collect(Collectors.toList());
        System.out.println("collect = " + collect);
        int[] answer = new int[collect.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = collect.get(0);

        }
        return collect;
    }

    public static void main(String[] args) {

        String msg = "THATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITISTHATTHATI" +
                "SISTHATTHATISNOTISNOTISTHATITITISTHATTHATISISTHATTHATISNOTISNOTISTHATITITIS";
        msg = "ABCDEFGHIJKLMNOPQRSTUVWXYZACABACAB";
        List<Integer> a = new Num2().solution(msg);


    }
}
