//https://www.acmicpc.net/problem/11286
//        절댓값 힙

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Num11286 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Num> priorityQueue = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int command = Integer.parseInt(br.readLine());
            if(command==0){
                if(priorityQueue.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append(priorityQueue.poll().toString());
                }
            }else{
                priorityQueue.add(new Num(command));
            }
        }
        System.out.println(sb.toString());
    }
}

class Num implements Comparable<Num>{
    int absNum;
    int num;

    public Num(int num){
        this.absNum = Math.abs(num);
        this.num = num;
    }

    @Override
    public int compareTo(Num o) {
        if(this.absNum==o.absNum){
            return this.num-o.num;
        }
        return this.absNum-o.absNum;
    }
    @Override
    public String toString() {
        return this.num+"\n";
    }
}
