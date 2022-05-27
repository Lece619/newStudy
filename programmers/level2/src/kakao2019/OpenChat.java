package kakao2019;
/*https://programmers.co.kr/learn/courses/30/lessons/42888?language=java*/

import java.util.HashMap;

public class OpenChat {
    public static void main(String[] args) {
        new OpenChat().solution(new String[] {"Enter uid1234 Muzi",
                 "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prod",
                "Change uid4567 Ryan"});
    }
    public String[] solution(String[] record) {
        int cnt = record.length;
        StringBuffer sb = new StringBuffer();
        HashMap<String,String> idMap = new HashMap<>();
        for (String s : record) {
            String[] id_name = s.split(" ");
            //키가 중복되면 변경
            if(id_name[0].equals("Leave")){
                continue;
            }
            idMap.put(id_name[1],id_name[2]);
            if(id_name[0].equals("Change")){
                cnt--;
            }
        }

        String[] answer = new String[cnt];
        int idx = 0;
        for (int i = 0; i < record.length; i++) {
            String[] log = record[i].split(" ");
            if(log[0].equals("Enter")){
                answer[idx]=idMap.get(log[1])+"님이 들어왔습니다.";
                idx++;
            }else if(log[0].equals("Leave")){
                answer[idx]=idMap.get(log[1])+"님이 나갔습니다.";
                idx++;
            }
        }
        for (String s : answer) {
            System.out.println(s);
        }
        return answer;
    }
}