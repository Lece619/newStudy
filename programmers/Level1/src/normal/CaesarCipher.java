package normal;

public class CaesarCipher {
    public static void main(String[] args) {
        System.out.println(solution("abcz  z  ",1));
    }
    public static String solution(String s, int n) {
        String check = s.replaceAll("[a-z]","a")
                .replaceAll("[A-Z]","A")
                .replaceAll(" ","0");
        String answer = "";
        for (int i = 0; i < s.length(); i++) {
            if(check.charAt(i)=='0'){
                answer+=" ";
                continue;
            }
            answer+=(char)(check.charAt(i)+(s.charAt(i)-check.charAt(i)+n)%26);
        }
        return answer;
    }
}
