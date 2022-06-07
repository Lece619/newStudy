//https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
//코딩테스트 연습 -탐욕법 - 조이스틱

package greedy;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        int count = name.length();
        boolean[] check = new boolean[name.length()];
        int[] move = new int[name.length()];
        for (int i = 0; i < name.length(); i++) {
            int toA = name.charAt(i)-'A';
            int toB = 'Z'-name.charAt(i)+1;
            move[i] = Math.min(toA,toB);
        }
        for (int i : move) {
            System.out.print(" "+i);
        }

        return answer;
    }
    //JAN
    //

    public int findNum(){
        return 0;
    }

    public static void main(String[] args) {
        String name= "JEROENZ";
        System.out.println(new JoyStick().solution(name));
    }
}
