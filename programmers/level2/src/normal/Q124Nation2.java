//https://programmers.co.kr/learn/courses/30/lessons/12899 124 나라의 숫자
package normal;

public class Q124Nation2 {
    public String solution(int n) {
        StringBuilder st = new StringBuilder();

        int newN=0;
        while(n!=0){
            StringBuilder a = new StringBuilder();
            newN = n%3;
            n /= 3;
            if(newN==0){
                newN = 4;
                n -= 1;
            }
            st = a.append(newN).append(st);
        }
        return st.toString();
    }


    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(new Q124Nation2().solution(i));
        }
    }
}
