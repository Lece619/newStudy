//https://programmers.co.kr/learn/courses/30/lessons/12899 124 나라의 숫자
package normal;

public class Q124Nation {
    public String solution(int n) {
        String answer="";
        int nowNum = 0;
        for (int i = 1; i <= n; i++) {
            String a = Integer.toUnsignedString(nowNum,4).replace("0","1");
            System.out.println(a);
            nowNum = Integer.parseInt(a,4)+1;
        }
        answer=Integer.toUnsignedString(nowNum).replace("3","4");
        System.out.println();
        System.out.println(nowNum);
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        new Q124Nation().solution(2);
    }
}
