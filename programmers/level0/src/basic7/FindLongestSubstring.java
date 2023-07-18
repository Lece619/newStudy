package basic7;

import java.util.Arrays;

public class FindLongestSubstring {
    public String solution(String myString, String pat, String sg) {
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }

    public int solution(String myString, String pat) {
        int answer = 0;
        while(myString.contains(pat)){
            answer++;
            myString = myString.substring(myString.indexOf(pat) + 1);
        }
        return answer;
    }
    public String[] solution(String[] strArr) {
        String[] answer = {};
        String[] ads = Arrays.stream(strArr).filter(str -> !str.contains("ad")).toArray(String[]::new);
        return Arrays.stream(strArr).filter(str -> !str.contains("ad")).toArray(String[]::new);
    }
}
