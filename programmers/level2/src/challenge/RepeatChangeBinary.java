/*
https://school.programmers.co.kr/learn/courses/30/lessons/70129
        코딩테스트 연습
        월간 코드 챌린지 시즌1
        이진 변환 반복하기
*/


package challenge;

public class RepeatChangeBinary {
    int[] answer = new int[2];
    public int[] solution(String s) {
        fineAnswer(s);
        return answer;
    }

    private void fineAnswer(String s) {
        if(s.equals("1")){
            return;
        }else{
            answer[0]++;
            String tempS = s.replaceAll("0","");
            answer[1] += s.length() - tempS.length();
            s = Integer.toBinaryString(tempS.length());
            fineAnswer(s);
        }
    }

    public static void main(String[] args) {
        RepeatChangeBinary repeatChangeBinary = new RepeatChangeBinary();
        String s = "1";
        int[] solution = repeatChangeBinary.solution(s);
        System.out.println("solution = " + solution[0] + " " + solution[1]);
    }
}
