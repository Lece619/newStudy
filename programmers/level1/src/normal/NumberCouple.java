/*
https://school.programmers.co.kr/learn/courses/30/lessons/131128
            연습문제
            숫자 짝꿍
*/

package normal;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberCouple {
    public String solution(String X, String Y) {
        /*시간초과
        ArrayList<Integer> answerList = new ArrayList<>();
        List<Character> listY = Y.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        for (int i = 0; i < X.length(); i++) {
            Character nowChar = X.charAt(i);
            if(listY.contains(nowChar)){
                 listY.remove(nowChar);
                 answerList.add(Character.getNumericValue(nowChar));
             }
        }

        String collect = answerList.stream().sorted(Comparator.reverseOrder()).map(String::valueOf).collect(Collectors.joining());
        if(collect.equals("")){
            return "-1";
        }else if(collect.replaceAll("0","").equals("")){
            return "0";
        }
        */
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        X.chars().mapToObj(c->(char)c).mapToInt(c->Character.digit(c,10)).forEach(a->arrX[a]++);
        Y.chars().mapToObj(c->(char)c).mapToInt(c->Character.digit(c,10)).forEach(a->arrY[a]++);
        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            sb.append(String.valueOf(i).repeat(Math.max(0, Math.min(arrX[i], arrY[i]))));
        }

        if(sb.length()==0){
            return "-1";
        }
        if(sb.charAt(0)=='0'){
            return "0";
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        NumberCouple numberCouple = new NumberCouple();
        String X = "100";
        String Y = "2345";
        String solution = numberCouple.solution(X, Y);
        System.out.println("solution = " + solution);
    }
}
