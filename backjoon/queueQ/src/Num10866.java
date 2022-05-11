/*
* 정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
*/

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num10866 {

    public static void main(String[] args) throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int num = Integer.parseInt(br.readLine());
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        DequeMake deque = new DequeMake(num);
        String bw ="";
        for (int i = 0; i < num; i++) {
            /*StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();*/
            String order = sc.next();
            int pushNum=0;

            switch (order){
                case "push_front" :
//                    pushNum =Integer.parseInt(st.nextToken());
                    pushNum =Integer.parseInt(sc.next());
                    deque.push_front(pushNum);
                    break;
                case "push_back" :
//                    pushNum =Integer.parseInt(st.nextToken());
                    pushNum =Integer.parseInt(sc.next());
                    deque.push_back(pushNum);
                    break;
                case "pop_front":
//                    bw.write(deque.pop_front()+"\n");
                    bw+=(deque.pop_front()+"\n");
                    break;
                case "pop_back":
//                    bw.write(deque.pop_back()+"\n");
                    bw+=(deque.pop_back()+"\n");
                    break;
                case "size":
                    bw+=(deque.size()+"\n");
//                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    bw+=(deque.empty()+"\n");
//                    bw.write(deque.empty()+"\n");
                    break;
                case "front":
                    bw+=(deque.front()+"\n");
//                    bw.write(deque.front()+"\n");
                    break;
                case "back" :
//                    bw.write(deque.back()+"\n");
                    bw+=(deque.back()+"\n");
                    break;
            }
        }
        System.out.println(bw);
//        deque.check();
//        bw.flush();
//        bw.close();
//        br.close();
    }

}
class DequeMake{
    int[] queue,temp;
    int front = 0, back = 0;
    String result;
    public DequeMake(int size){
        queue = new int[size+2];
        temp = new int[size+2];
    }
    public void push_front(int num){
        temp[front]=num;
        for(int i = front ;i < back ; i++){
            temp[i+1]=queue[i];
        }
        queue=temp;
        temp=new int[queue.length];
        back++;
    }
    public void push_back(int num){
        queue[back] = num;
        back++;
    }
    public String pop_front(){
        if(front==back){
            return "-1";
        }else {
            result = "" + queue[front];
            front++;
            return result;
        }
    }
    public String pop_back(){
        if(front==back){
            return "-1";
        }else {
            back--;
            result = "" + queue[back];
            return result;
        }
    }
    public String size(){
        result = ""+(back-front);
        return result;
    }
    public String empty(){
        if(front==back){
            return "1";
        }else {
            return "0";
        }
    }
    public String front(){
        if(front==back){
            return "-1";
        }else{
            return ""+queue[front];
        }
    }
    public String back(){
        if(front==back){
            return "-1";
        }else {
            return ""+queue[back-1];
        }
    }
    public void check(){
        System.out.println("----");
        System.out.println(front);
        System.out.println(back);
        for (int i : queue) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("----");
    }
}
