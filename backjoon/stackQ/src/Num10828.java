
/*
* 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Num10828 {

    public static void main(String[] args) throws IOException {
        Stack stack=new Stack();
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        Scanner sc =new Scanner(System.in);
        int num=Integer.parseInt(br.readLine());
        String[] order=new String[2];
        for (int i = 0; i <num; i++) {
            order=br.readLine().split(" ");
            switch (order[0]){
                case "push":
                    stack.push(Integer.parseInt(order[1]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "size":
                    stack.size();
                    break;
                case "empty":
                    stack.empty();
                    break;
                case "top":
                    stack.top();
                    break;
            }
        }
    }
}
 class Stack{
    public int size=0;
    public int[] arr=new int[10000];
    public void push(int num){
        arr[size]=num;
        size++;
    }
    public void pop(){
        if (size == 0) {
            System.out.println(-1);
        }
        else{
            System.out.println(arr[size-1]);
            arr[size-1]=0;
            size--;
        }
    }
    public void size(){
        System.out.println(size);
    }
    public void empty(){
        if(size==0){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    public void top(){
        if(size==0)
            System.out.println(-1);
        else
            System.out.println(arr[size-1]);
    }
}
