package basic3;

public class CtrlZ {
    public int solution(String s) {
        int answer = 0;
        String[] numOrZ = s.split(" ");
        int nowNum = 0;
        for (String word : numOrZ) {
            nowNum = getNowNum(nowNum, word);
            answer += nowNum;
        }
        return answer;
    }

    private int getNowNum(int nowNum, String word) {
        if(!word.equals("Z")){
            return Integer.parseInt(word);
        }
        return -1 * nowNum;
    }
}
