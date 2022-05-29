//https://programmers.co.kr/learn/courses/30/lessons/12899 124 나라의 숫자
package normal;

import java.util.ArrayList;

public class Q124Nation {
    public String solution(int n) {
        String answer="";
        System.out.println();
        System.out.println(n);
        int count=0;
        for (int i = 1; i <= n; i++) {
            count+=Integer.toUnsignedString(i,4).chars().filter(c->c=='0').count();
        }
//        int nowNum = 0;
//        for (int i = 1; i <= n; i++) {
//            nowNum+=1;
//            String a = Integer.toUnsignedString(nowNum,4).replace("0","1");
//            nowNum = Integer.parseInt(a,4);
//        }
        n+=count;
        StringBuilder sb = new StringBuilder();
        int p = Integer.parseInt(Integer.toUnsignedString(n,4).replace("0","1"),4);
        answer=Integer.toUnsignedString(p,4).replace("3","4");
        //answer=Integer.toUnsignedString(nowNum,4).replace("3","4");

//        System.out.println(nowNum);
        System.out.println(answer);
        return answer;
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Q124Nation().solution(i);
        }
    }
}
