//https://programmers.co.kr/learn/courses/30/lessons/12952
//NQueen

package normal;

public class NQueen {
    int[] queens;
    int queenSize;
    int count;
    public int solution(int n) {
        queens=new int[n];
        queenSize = n;
        int answer = 0;
        count = 0;
        find(0);
        return count;
    }

    public void find(int n){
        if(n==queenSize){
            count++;
            return;
        }
        for (int i = 0; i < queenSize; i++) {
            queens[n] = i;
            if(isOk(n)){
                //System.out.println(n);
                find(n+1);
            }
        }
    }

    public boolean isOk(int n){
        for (int i = 0; i < n; i++) {
            if(queens[n] == queens[i] ||Math.abs(queens[n]-queens[i])==Math.abs(n-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().solution(4));
    }
}
