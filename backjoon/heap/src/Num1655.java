//https://www.acmicpc.net/problem/1655   가운데를 말해요


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n  = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i <n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()){
                maxHeap.add(num);

                if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
            }else{
                minHeap.add(num);
                if(maxHeap.peek() > minHeap.peek()){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(maxHeap.poll());
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
