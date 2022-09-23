/*
https://school.programmers.co.kr/learn/courses/30/lessons/17681
        2018 KAKAO BLIND RECRUITMENT
        [1차] 비밀지도
*/

package kakao2018;

public class TreasureMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int a = 9;
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            int makeOr = arr1[i] | arr2[i];
            String s = Integer.toBinaryString(makeOr);
            String moreZero = "";
            if(s.length() < n){
                for (int j = 0; j < n-s.length(); j++) {
                    moreZero += "0";
                }
            }
            answer[i] = (moreZero+s).replaceAll("0"," ").replaceAll("1","#");

        }
        return answer;
    }

    public static void main(String[] args) {
        TreasureMap treasureMap = new TreasureMap();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] answer = treasureMap.solution(n, arr1, arr2);
    }
}
