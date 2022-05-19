package callengeSeason;

public class RemainderOne {

class Solution {
    public int solution(int n) {
        int cnt=1;
        while(true){
            if(n%cnt==1){
                break;
            }
            cnt++;
        }
        int answer = cnt;
        return answer;
    }
}
}
