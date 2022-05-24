package normal;

public class FindKim {
class Solution {
    public String solution(String[] seoul) {
        int index = 0;
        for (String s : seoul) {
            if(s.equals("Kim")){
                break;
            }
            index++;
        }
        String answer = "김서방은 "+ index+"에 있다";
        return answer;
    }
}
}
