package kakao2018;

public class DartGame {
    public static void main(String[] args) {
        new DartGame().new Solution().solution("1S2D*3T");
    }
class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String temp = "";
        temp = dartResult.replaceAll("[SDT]"," ");
        temp = temp.replaceAll("[*#]","");
        System.out.println(temp);
        String[] num = temp.split(" ");
        String[] option = dartResult.replaceAll("[0-9]"," ")
                .replaceAll("[ {2,]"," ").replaceAll("^[ ]","").split(" ");
        System.out.println(option[0]+" "+option[1]+" "+option[2]+" ");
        return answer;
    }
}
}
