//https://programmers.co.kr/learn/courses/30/lessons/12911  
//다은 큰 숫자
package normal;

public class NextBigNumber {
    public int solution(int n) {
        String binaryNum = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i <binaryNum.length(); i++) {
            if(binaryNum.charAt(i)=='1'){
                count++;
            }
        }
        while(true){
            n++;
            int tempCnt=0;
            binaryNum = Integer.toBinaryString(n);
            for (int i = 0; i <binaryNum.length(); i++) {
                if(binaryNum.charAt(i)=='1'){
                    tempCnt++;
                }
            }
            if(count==tempCnt){
                break;
            }
        }
        return n;
    }
}
