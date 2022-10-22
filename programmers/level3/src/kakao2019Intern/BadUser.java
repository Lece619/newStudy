/*
https://school.programmers.co.kr/learn/courses/30/lessons/64064
        2019 카카오 개발자 겨울 인턴십
        불량 사용자
*/


        package kakao2019Intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

public class BadUser {

    Stack<String> userStack = new Stack<>();
    ArrayList<ArrayList<String>> everyUser = new ArrayList<>();

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        ArrayList<String> bannedList = new ArrayList<>();
        for (String s : banned_id) {
            String reg = s.replaceAll("\\*", "[\\\\w]{1}");
            bannedList.add(reg);
        }

        makeDfs(user_id, 0, banned_id.length);

        for (ArrayList<String> users : everyUser) {
            answer += addAnser(users, bannedList);
        }

        return answer;
    }

    private int addAnser(ArrayList<String> users, ArrayList<String> bannedList) {
        int[] usedIdx = new int[bannedList.size()];
        Arrays.fill(usedIdx, -1);

        for (int j = 0; j < bannedList.size(); j++) {
            for (int i = 0; i < users.size(); i++) {
            String user = users.get(i);
                String bannedReg = bannedList.get(j);
                if (Pattern.matches(bannedReg, user)) {
                    if(usedIdx[i] == -1){
                        usedIdx[i] = j;
                    }else{
                        int idx = usedIdx[i];
                        long count = Arrays.stream(usedIdx).filter(a -> a == idx).count();
                        if(count > 1){
                            usedIdx[i] = j;
                        }
                    }
                }
            }

        }

        return bannedList.size() == Arrays.stream(usedIdx).filter(i->i!=-1).distinct().count() ? 1 : 0;
    }

    private void makeDfs(String[] user_id, int n, int targetLen) {
        if (userStack.size() == targetLen) {
            everyUser.add(new ArrayList<>(userStack));
            return;
        }
        for (int i = n; i < user_id.length; i++) {
            userStack.push(user_id[i]);
            makeDfs(user_id, i + 1, targetLen);
            userStack.pop();
        }
    }

    public static void main(String[] args) {
        BadUser badUser = new BadUser();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};

        int solution = badUser.solution(user_id, banned_id);
        System.out.println("solution = " + solution);
    }
}
