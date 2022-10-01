/*
https://school.programmers.co.kr/learn/courses/30/lessons/120924
        코딩테스트 입문
        다음에 올 숫자
*/

package basic;

public class NextNum {

    public int solution(int[] common) {
        int answer = 0;
        int differenceOne = common[1] - common[0];
        int differenceTwo = common[2] - common[1];
        if(differenceOne == differenceTwo){
            return common[common.length-1]+differenceOne;
        }else{
            return common[common.length-1] * common[1]/common[0];
        }
    }

    public static void main(String[] args) {
        NextNum nextNum = new NextNum();
        int[] common = {1, 2, 3, 4};
        int solution = nextNum.solution(common);
        System.out.println("solution = " + solution);
    }
}
