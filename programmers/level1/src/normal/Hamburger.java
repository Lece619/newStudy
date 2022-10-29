/*
https://school.programmers.co.kr/learn/courses/30/lessons/133502
        연습문제
        햄버거 만들기
*/

package normal;


import java.util.Stack;

public class Hamburger {

        public int solution(int[] ingredient) {
            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < ingredient.length - 1; i++) {
                if(stack.size() < 2 ){
                    stack.add(ingredient[i]);
                    continue;
                }

                int num2 = stack.pop();
                int num1 = stack.pop();
                int num3 = ingredient[i];
                int num4 = ingredient[i+1];

                if(num1 == 1 && num2 == 2 && num3 == 3 && num4 == 1){
                    i++;
                    answer++;
                }else{
                    stack.add(num1);
                    stack.add(num2);
                    stack.add(num3);
                }
            }

            return answer;
        }

    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger();
        int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        System.out.println("hamburger = " + hamburger.solution(ingredient));
    }

}
