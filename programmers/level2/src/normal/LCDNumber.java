//https://programmers.co.kr/learn/courses/30/lessons/12953?language=java
//코딩테스트 연습연습문제 N개의 최소공배수
package normal;

public class LCDNumber {
    public int solution(int[] arr) {
        int answer = 0;
        int gcmTotal = 0;
        //a~ b까지 gcm total을 구하면 된다.
        int totalMulti = arr[0];
        for (int i = 1; i < arr.length; i++) {
            gcmTotal = gcm(arr[i],totalMulti);
            totalMulti = totalMulti*arr[i]/gcmTotal;
        }
        return totalMulti;
    }

    //유클리드 호제법
    public int gcm(int a, int b){
        if(b==0){
            return a;
        }else{
            return gcm(b , a%b);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(new LCDNumber().solution(arr));
    }
}
