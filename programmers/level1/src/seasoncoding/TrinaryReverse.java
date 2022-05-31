package seasoncoding;

import java.util.Stack;

public class TrinaryReverse {
    public static void main(String[] args) {
    }
    class Solution {
        public int solution(int n) {
            int answer = 0;
            Stack<Integer> stack = new Stack<>();

            while(!(n < 3)){
                stack.add(n%3);
                n/=3;
            }
            stack.add(n);
            int thri=1;
            while(!stack.isEmpty()){
                answer+=stack.pop()*thri;
                thri*=3;
            }
            return answer;
        }
        //Integer.parseInt(a,3); String a parseInt by Trinary.
    }
}

/*
*  3 12 -0
*  3  4 -1
*     1
*   3 45 -0
*   3 15 -0
*   3 5  -2
*     1
* 3 125 -2
* 3 41  -2
* 3 13  -1
* 3 4   -1
*   1
*
* */