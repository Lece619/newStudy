package kakao2018;

public class DartGame {
    public static void main(String[] args) {
        new DartGame().new Solution().solution("1D2S3T*");
}
class Solution {
    public int solution(String dartResult) {
        dartResult+="X";//마지막
        int answer=0;
        String[] nums = dartResult.replaceAll("[TDS]"," ")
                .replaceAll("[#*X]","").split(" ");
        int lastScore=0;
        for (String num : nums) {
            int score = Integer.parseInt(num);
            int option =1;
            if(dartResult.charAt(num.length()+1)=='#'||dartResult.charAt(num.length()+1)=='*'){
                option = dartResult.charAt(num.length()+1)=='#' ? -1 : 2 ;
            }
            if(dartResult.charAt(num.length())=='D') {
                score*=score;
            }
            if(dartResult.charAt(num.length())=='T'){
                score*=score*score;
            }
            if(option==2) {
                score*=2;
                answer+=lastScore + score;
            }else{
                score*=option;
                answer+=score;
            }
            System.out.println(lastScore+"마지막숫자 " + score+" 스코어"+answer);
            lastScore=score;
            if(option==1){
                dartResult=dartResult.substring(num.length()+1);
            }else{
                dartResult=dartResult.substring(num.length()+2);
            }
        }
        System.out.println();
        System.out.println();
        System.out.println(answer);
        return answer;
    }
}
}
