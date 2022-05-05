/*
* 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
* Ai의 오큰수는 오른쪽에 있으면서
* Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
* A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
*
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Num17298 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[n];


        Stack<Integer> stack = new Stack<>();
        //Stack<Integer> stack2= new Stack<>();

        for (int i = 0; i < n; i++) {
            result[i] = Integer.parseInt(st.nextToken());
        }
        //index로 확인
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && result[stack.peek()] < result[i]) {
                result[stack.pop()] = result[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()]=-1;
        }
        String total="";
        for (int i : result) {
            total+=i+" ";
        }
        System.out.println(total);
    }
}
        /*4
        3 5 2 7 인 경우
         i=0일때
         stack 0
         i=1일때
         result[stack.peek()= 0] < result[1] 이므로
         result[0]=result[1]
         stack 0 => stack 1
         i=2 일때
         result[1] > result[2] 이므로
         그냥 stack 1 2
         i=3 일때
         result[2] <result[3] 이므로 result[2]=result[3]
         result[1] <result[3] 이므로 result[1]=result[3]
         stack isEmpty 후
         stack.push(i) 남아있는 stack 원소들은 -1로

        */

/*        int idx=n-1;
        while(!stack.isEmpty()){
            int num = stack.pop();
            if(stack2.isEmpty()){
                result[idx] = -1;
                idx--;
            }else {
                boolean flag = true;
                while (stack2.peek() < num) {
                    stack2.pop();
                    if (stack2.isEmpty()) {
                        result[idx] = -1;
                        idx--;
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    result[idx]=stack2.peek();
                    idx--;
                }
            }
            stack2.push(num);
        }*/

