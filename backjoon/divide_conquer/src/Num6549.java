//https://www.acmicpc.net/problem/6549
//백준 분할정복 - 히스토그램에서 가장 큰 직사각형

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num6549 {

    static int[] numArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            numArr = new int[n];
            Stack<Integer> stack = new Stack<>();
            long max = 0;
            if(n==0){
                break;
            }

            for (int i = 0; i < n; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
                //
                while(!stack.isEmpty() && numArr[stack.peek()] >= numArr[i]){
                    int h = numArr[stack.pop()];
                    long w = stack.isEmpty() ? i : i - 1 - stack.peek();
                    max = Math.max(max,h*w);
                }
                stack.push(i);
            }
            while(!stack.isEmpty()){
                int h = numArr[stack.pop()];
                long w = stack.isEmpty() ? n : n - 1 - stack.peek();
                max = Math.max(max,h*w);
            }
            sb.append(max).append("\n");
            numArr = null;
        }
        System.out.println(sb);
    }
}
