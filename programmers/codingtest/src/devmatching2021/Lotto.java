package devmatching2021;

public class Lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt=0;
        int cnt=0;
        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i]==0){
                zeroCnt++;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if(win_nums[j]==lottos[i]){
                    cnt++;
                }
            }
        }

        int[] answer = {7-cnt-zeroCnt,7-cnt};
        if(answer[1]==7){
            answer[1]--;
        }
        if(answer[0]==7){
            answer[0]--;
        }
        return answer;
    }
}
