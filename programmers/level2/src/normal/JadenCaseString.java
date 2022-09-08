/*
https://school.programmers.co.kr/learn/courses/30/lessons/12951
        연습문제
        JadenCase 문자열 만들기
*/
package normal;

public class JadenCaseString {

    public String solution(String s) {
        StringBuilder st = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                st.append(" ");
                isFirst = true;
                continue;
            }

            if(isFirst){
                st.append(Character.toUpperCase(s.charAt(i)));
                isFirst = false;
            }else{
                st.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {
        JadenCaseString jadenCaseString = new JadenCaseString();
        System.out.println("jadenCaseString.solution(\"3people unFollowed me\") = " + jadenCaseString.solution("3people unFollowed me"));
    }
}
