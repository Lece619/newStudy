/*
https://school.programmers.co.kr/learn/courses/30/lessons/148652
        연습문제
        유사 칸토어 비트열
*/

package normal2;

public class CantorBit {

    final static String CHANGE_ONE = "11011";
    final static String TEMP_ZERO = "X";
    final static String CHANGE_ZERO = "00000";

    public int solution(int n, long l, long r) {
        int answer = 0;
        String cantor = "1";

        for (int i = 0; i < n; i++) {
            cantor = makeNextCantor(cantor);
            System.out.println("cantor = " + cantor);
            System.out.println("cantor = " + cantor.replaceAll("1","").length());
            System.out.println("cantor = " + cantor.replaceAll("0","").length());
        }



        return answer;
    }

    private String makeNextCantor(String cantor) {
        return cantor.replaceAll("0", TEMP_ZERO)
                .replaceAll("1",CHANGE_ONE)
                .replaceAll(TEMP_ZERO,CHANGE_ZERO);
    }

    public static void main(String[] args) {
        CantorBit cantorBit = new CantorBit();
        int n = 6;
        long l = 4;
        long r = 17;
        int solution = cantorBit.solution(n, l, r);
        System.out.println("solution = " + solution);
    }
}
