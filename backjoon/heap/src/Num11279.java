
//https://www.acmicpc.net/problem/11279
//백준 - 최대 힙
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Num11279 {

    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Scanner sc = new Scanner(System.in);
        StringBuilder s  = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int command = sc.nextInt();
            if(command==0){
                if(pQueue.isEmpty()){
                    s.append("0\n");
                }else {
                    s.append(pQueue.poll() + "\n");
                }
            }
            else{
                pQueue.add(command);
            }
        }
        System.out.println(s.toString());
    }
}
