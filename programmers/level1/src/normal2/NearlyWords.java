package normal2;

import java.util.Arrays;

public class NearlyWords {
    public int[] solution(String s) {
        int[] numOfChar = new int[ 'z' - 'a' + 1 ];
        Arrays.fill(numOfChar,-1);
        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            if(numOfChar[target-'a'] == -1){
                answer[i] = -1;
                numOfChar[target - 'a'] = i;
                continue;
            }
            answer[i] = i - numOfChar[target - 'a'];
            numOfChar[target-'a'] = i;
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "bananab";
        NearlyWords nearlyWords = new NearlyWords();
        int[] solution = nearlyWords.solution(s);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
        
    }
}
