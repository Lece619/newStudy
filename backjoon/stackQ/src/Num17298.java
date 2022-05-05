/*
* 크기가 N인 수열 A = A1, A2, ..., AN이 있다. 수열의 각 원소 Ai에 대해서 오큰수 NGE(i)를 구하려고 한다.
* Ai의 오큰수는 오른쪽에 있으면서
* Ai보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다. 그러한 수가 없는 경우에 오큰수는 -1이다.

예를 들어, A = [3, 5, 2, 7]인 경우 NGE(1) = 5, NGE(2) = 7, NGE(3) = 7, NGE(4) = -1이다.
* A = [9, 5, 4, 8]인 경우에는 NGE(1) = -1, NGE(2) = 8, NGE(3) = 8, NGE(4) = -1이다.
*
* */

import java.util.Scanner;
import java.util.Stack;

public class Num17298 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        String[] number=new String[n];
        int[] result=new int[n];
        sc.nextLine();
        number=sc.nextLine().split(" ");
        for (int i = 0; i < nums.length; i++) {
            nums[i]=Integer.parseInt(number[i]);
            result[i]=-1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]<nums[j]) {
                    result[i]=nums[j];
                    break;
                }
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }

//        Stack<Integer> stack = new Stack<>();
//        Stack<Integer> result= new Stack<>();
//        int maxNum,currentNum,nextNum;
//        for (int i = 0; i < n ; i++) {
//            stack.push(sc.nextInt());
//        }
//        result.push(-1);
//        maxNum=stack.pop();
//        currentNum=maxNum;
//        while(!stack.isEmpty()){
//            nextNum=stack.pop();
//            if(nextNum>=maxNum){
//                result.push(-1);
//                maxNum=nextNum;
//                continue;
//            }
//
            // 5 3 1 8 6 7 9

        //}
    }
}
