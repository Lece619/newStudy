//https://programmers.co.kr/learn/courses/30/lessons/60058
//코딩테스트 연습
//2020 KAKAO BLIND RECRUITMENT
//괄호 변환

package kakao2020;

//        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.
public class ChangeBracket {
    public String solution(String p) {
        String answer = "";
        int count = 0;
        int index = 0;
        if(p.equals("")) return "";
        String u = null,v = null;
        for (int i = 0 ; i < p.length(); i++) {
            count = p.charAt(i)=='(' ? count+1 : count-1;
            if(count==0){
                u=p.substring(0,i+1);
                v=p.substring(i+1);
                index=i;
                break;
            }
        }
        if(checkString(u)){
            return u+solution(v);
        }else{
            String newP = "("+solution(v)+")";
            for (int i = 1; i < u.length()-1 ; i++) {
                newP += u.charAt(i)=='(' ? ")" : "(";
            }
            return newP;
        }
    }

    public boolean checkString(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count = str.charAt(i)=='(' ? count+1 : count-1;
            if(count<0){
                return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String test = "))()()((";
        System.out.println(new ChangeBracket().checkString(test));
    }
}
