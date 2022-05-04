/*
 * 스택 (stack)은 기본적인 자료구조 중 하나로, 컴퓨터 프로그램을 작성할 때
 * 자주 이용되는 개념이다. 스택은 자료를 넣는 (push) 입구와 자료를 뽑는 (pop)
 * 입구가 같아 제일 나중에 들어간 자료가 제일 먼저 나오는 (LIFO, Last in First out) 특성을 가지고 있다.
 * 1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다.
 * 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
 * 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
 * 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다. 이를 계산하는 프로그램을 작성하라.
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Num1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        boolean check = true;
        //기본스텍
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ArrayList<String> result = new ArrayList<>();

        IntStream.range(-n, 0).forEach(value -> stack1.add(-value));
        //IntStream.range(1000,1).forEach(stack1::add);
        int maxNum = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            //입력받은 수가 maxNum 보다 클때
            if (check) {
                if (num > maxNum) {
                    for (int j = 0; j < num - maxNum; j++) {  //5  3  7
                        stack2.push(stack1.pop());
                        result.add("+");
                    }
                    maxNum = num;
                }
                if (num == stack2.peek()) {
                    stack2.pop();
                    result.add("-");
                } else {
                    check = false;
                }
            }
        }
        if (check) {
            for (String s : result) {
                System.out.println(s);
            }
        } else {
            System.out.println("NO");
        }
    }
}
