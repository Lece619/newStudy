package kakao2021;

public class NewID {
    public static void main(String[] args) {
//        String new_id="...!@BaT#*..y.abcdefghijklm";
        String new_id="=.=";
        System.out.println(new Solution().solution(new_id));

    }
}
class Solution {
    public String solution(String new_id) {
        //1단계 소문자 바꾸기
        String answer = new_id.toLowerCase();
        //2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)
        String temp ="";
        for (int i = 0; i < answer.length(); i++) {
            char ch=answer.charAt(i);
            if((i==0||i==answer.length()-1)&&ch=='.'){
                continue;
            }
            else if((ch>='a'&&ch<='z')||(ch>='0'&&ch<='9')||ch=='-'||ch=='_'||ch=='.'){
                temp+=ch;
            }
        }
        answer=temp;
        //3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)
        temp="";
        int cntDot=0;
        for (int i = 0; i < answer.length(); i++) {
            char ch=answer.charAt(i);
            if(ch=='.'){
                cntDot++;
                continue;
            }
            else{
                if(cntDot>0){
                    temp+=".";
                    cntDot=0;
                }
                temp+=ch;
            }
        }

        answer=temp;

        //4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다
        temp="";
        for (int i = 0; i < answer.length(); i++) {
            char ch=answer.charAt(i);
            if((i==0||i==answer.length()-1)&&ch=='.'){
                continue;
            }
            else {
                temp+=ch;
            }
        }
        answer=temp;
        //5단계 빈문자열이라면 a 대입
        if(answer.length()==0){
            answer="a";
        }
        //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(answer.length()>15){
            answer=answer.substring(0,15);
        }
        //다시 4단계확인
        temp="";
        for (int i = 0; i < answer.length(); i++) {
            char ch=answer.charAt(i);
            if((i==0||i==answer.length()-1)&&ch=='.'){
                continue;
            }
            else {
                temp+=ch;
            }
        }
        answer=temp;
        if(answer.length()<3){

            while(answer.length()<3){
                System.out.println("추가" + answer.charAt(answer.length()-1));
                answer+=answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}