package kakao2018;

import java.util.Locale;

public class NotationGame {

    public String solution(int n, int t, int m, int p) {
        StringBuilder number = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        int num = 0;
        int totalLength = 0;
        while(number.length() < (m * t + p)){
            number.append(Integer.toUnsignedString(num++, n));
        }
        for (int i = p-1; i < number.length(); i += m) {
            answer.append(number.charAt(i));
            if(answer.length() == t){
                break;
            }
        }
        
        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        NotationGame notationGame = new NotationGame();


        String s = Integer.toUnsignedString(9, 16);
        System.out.println("s = " + s);
        s = Integer.toUnsignedString(15, 16);
        System.out.println("s = " + s);
        System.out.println("notationGame = " + notationGame.solution(2, 4, 2, 1));
    }
}
