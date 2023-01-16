/*
https://school.programmers.co.kr/learn/courses/30/lessons/148652
        연습문제
        유사 칸토어 비트열
*/

package normal2;

public class CantorBit {

    public int solution(int n, long l, long r) {
        return (int)(countOne(n, r) - countOne(n, l-1));
    }

    public long countOne(int n, long r){
        if(r == 0){
            return 0;
        }
        int powNum = findLimitPow(n, r);
        long preBitsNum = (long) Math.pow(5, powNum);
        long split = r / preBitsNum;
        long remain = r % preBitsNum;

        if(split==2){
            remain = 0;
        }
        if(split>=3){
            split--;
        }

        return (long) Math.pow(4, powNum) * split + countOne(powNum, remain);
    }

    private int findLimitPow(int n, long r) {
        int powNum;
        for (powNum = 0; powNum < n; powNum++) {
            if((long)Math.pow(5, powNum + 1) > r){
                return powNum;
            }
        }
        return powNum;
    }


    public static void main(String[] args) {
        CantorBit cantorBit = new CantorBit();
        int n = 2;
        long l = 4;
        long r = 17;
        int solution = cantorBit.solution(n, l, r);
        System.out.println("solution = " + solution);
    }
}
