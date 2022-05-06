/*정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

        명령은 총 여섯 가지이다.

        push X: 정수 X를 큐에 넣는 연산이다.
        pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        size: 큐에 들어있는 정수의 개수를 출력한다.
        empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

import java.util.Scanner;

public class Num18258 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Q queue = new Q(num);
        for (int i = 0; i < num; i++) {
            String choice = sc.next();
            switch (choice) {
                case "push":
                    int pushNum=sc.nextInt();
                    queue.push(pushNum);
                    break;
                case "pop":
                    queue.pop();
                    break;
                case "size":
                    queue.size();
                    break;
                case "empty":
                    queue.empty();
                    break;
                case "front":
                    queue.front();
                    break;
                case "back":
                    queue.back();
                    break;
            }
        }
    }

}

class Q {
    int[] queue;
    int frontIdx = 0;
    int lastIdx = 0;

    public Q(int num) {
        queue = new int[num];
    }

    public void push(int pushNum) {
        queue[lastIdx] = pushNum;
        lastIdx++;
    }

    public void pop() {
        if (frontIdx == lastIdx) {
            System.out.println(-1);
        } else {
            System.out.println(queue[frontIdx]);
            frontIdx++;
        }
    }

    public void size() {
        System.out.println(lastIdx - frontIdx);
    }

    public void empty() {
        if (lastIdx == frontIdx) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public void front() {
        if (frontIdx == lastIdx) {
            System.out.println(-1);
        }else{
            System.out.println(queue[frontIdx]);
        }
    }

    public void back() {
        if (frontIdx == lastIdx) {
            System.out.println(-1);
        }else{
            System.out.println(queue[lastIdx-1]);
        }
    }
}
