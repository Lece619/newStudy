//https://www.acmicpc.net/problem/1927
// 백준 - 우선순위 큐 - 최소 힙

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Num1927 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
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
