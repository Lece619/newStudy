/*
https://school.programmers.co.kr/learn/courses/30/lessons/155652
        연습문제
        둘만의 암호
*/

package normal2;

public class PasswordForTwoPeople {

    public String solution(String s, String skip, int index) {

        StringBuilder sb = new StringBuilder();
        for(char nowChar : s.toCharArray()){
            sb.append(makeWord(nowChar, skip, index));
        }

        return sb.toString();
    }

    private char makeWord(char nowChar, String skip, int index) {
        if(index == 0){
            return nowChar;
        }
        nowChar = moveNext(nowChar);

        if(skip.contains(String.valueOf(nowChar))){
            return makeWord(nowChar, skip, index);
        }
        return makeWord(nowChar, skip, index - 1);
    }

    private char moveNext(char nowChar) {
        if(nowChar == 'z'){
            return 'a';
        }
        return (char)(nowChar + 1);
    }

    public static void main(String[] args) {

        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

        PasswordForTwoPeople passwordForTwoPeople = new PasswordForTwoPeople();
        String solution = passwordForTwoPeople.solution(s, skip, index);
        System.out.println("solution = " + solution);
    }
}
