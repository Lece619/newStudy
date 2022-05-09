/*
* 요세푸스 문제는 다음과 같다.

*1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
* 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진
* 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
* 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-
* 요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

*N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Num11866 {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        String result = "<";
        int n = sc.nextInt(), k  = sc.nextInt();
        for (int i = 1; i < n+1 ; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()){
            int next = queue.poll();
            for (int i = 1; i < k; i++) {
                queue.add(next);
                next = queue.poll();
            }
            if(queue.isEmpty()){
                result+=next+">";
            }else{
                result+=next+", ";
            }
        }
        System.out.println(result);
    }
}
