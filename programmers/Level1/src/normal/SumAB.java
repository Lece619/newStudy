package normal;

public class SumAB {
class Solution {
    public long solution(int a, int b) {
        long sum =0;
        int a1=Math.min(a,b);
        int b1=Math.max(a,b);
//        for (int i = a1; i <= b1; i++) {
//            sum += i;
//        }
        sum=(b1-a1+1)*(a1+b1)/2;
        return sum;
    }
}
}
