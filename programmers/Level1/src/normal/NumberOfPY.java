package normal;

public class NumberOfPY {
class Solution {
    boolean solution(String s) {
        String s1=s.toUpperCase();
        //int p = s.replaceAll("[^pP]", "").length()
        //int y = s.replaceAll("[^yY]","").length()  ->[] 내부의 ^은 not을 의미
        int p=0;
        int y=0;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)=='P'){
                p++;
            }
            if(s1.charAt(i)=='Y'){
                y++;
            }
        }

        boolean answer = p==y;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
}
