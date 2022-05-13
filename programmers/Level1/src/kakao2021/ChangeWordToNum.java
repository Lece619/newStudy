package kakao2021;

public class ChangeWordToNum {

    class Solution {
        public int solution(String s) {
            String[] numWord= {"zero","one","two","three","four","five","six","seven","eight","nine"};
            int answer = 0;
            for (int i = 0; i < numWord.length; i++) {
                s = s.replaceAll(numWord[i],""+i);
            }
            answer = Integer.parseInt(s);
            return answer;
        }
    }
}
