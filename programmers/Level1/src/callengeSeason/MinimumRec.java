package callengeSeason;

public class MinimumRec {

class Solution {
    public int solution(int[][] sizes) {
        int max=0;
        int min=0;
        for (int[] size : sizes) {
            int maxNum = Math.min(size[0],size[1]);
            int minNum = Math.max(size[0],size[1]);
            if(minNum>min){
                min=minNum;
            }
            if(maxNum>max){
                max=maxNum;
            }
        }
        int answer = min*max;
        return answer;
    }
}

}
