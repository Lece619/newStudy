/*
https://school.programmers.co.kr/learn/courses/30/lessons/68646
        월간 코드 챌린지 시즌1
        풍선 터트리기
*/

package challenge;

public class BalloonPopping {

    public int solution(int[] a) {
        int answer = 0;
        int max = Integer.MAX_VALUE;
        int right = max;
        int left = max;
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        leftMin[0] = left;
        rightMin[a.length-1] = right;
        for (int i = 1; i < a.length; i++) {
            leftMin[i] = Math.min(a[i-1], left);
            left = leftMin[i];
        }
        for (int i = rightMin.length-2; i >= 0;  i--) {
            rightMin[i] = Math.min(a[i+1], right);
            right = rightMin[i];
        }

        for (int i = 0; i < a.length; i++) {
            if( a[i] < Math.max(rightMin[i],leftMin[i])){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};

        BalloonPopping balloonPopping = new BalloonPopping();

        System.out.println("balloonPopping.solution(a) = " + balloonPopping.solution(a));
    }
}
