package basic3;

public class NoThreeNum {

    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer++;
            if(answer % 3 == 0){
                continue;
            }
            if(String.valueOf(answer).contains("3")){
                continue;
            }
            n--;
        }

        return answer;
    }

}
