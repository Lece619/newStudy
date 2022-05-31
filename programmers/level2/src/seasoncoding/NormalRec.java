//https://programmers.co.kr/learn/courses/30/lessons/62048?language=java
//프로그래머스 - 멀쩡한 사각형

package seasoncoding;

public class NormalRec {
    public long solution(int w, int h) {
        int gcds = gcd(w,h);
        int smallW= w/gcds;
        int smallH= h/gcds;
        int small=smallW+smallH-1;

        long answer=(long)w*h-(long)small*gcds;
        return answer;
    }
    //최소공배수 -1;

    //최대 공약수
    public int gcd(int a, int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}
