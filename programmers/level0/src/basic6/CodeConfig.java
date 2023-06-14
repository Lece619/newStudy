package basic6;

public class CodeConfig {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {

            char c = code.charAt(i);

            if( c == '1'){
                mode = (mode + 1) % 2;
                continue;
            }

            answer += addChar(c, i, mode);
        }
        return answer == "" ? "EMPTY" : answer;
    }
    //acbac
    private String addChar(char c, int idx, int mode) {
        if(idx % 2 == mode){
            return String.valueOf(c);
        }
        return "";
    }

    public static void main(String[] args) {
        CodeConfig codeConfig = new CodeConfig();
        System.out.println(codeConfig.solution("abc1abc1abc"));
    }
}
