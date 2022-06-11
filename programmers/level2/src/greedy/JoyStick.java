//https://programmers.co.kr/learn/courses/30/lessons/42860?language=java
//코딩테스트 연습 -탐욕법 - 조이스틱

package greedy;

public class JoyStick {
    static int[] move;
    int nowIndex;
    public int solution(String name) {
        int answer = 0;
        move = new int[name.length()];
        for (int i = 0; i < name.length(); i++) {
            int toA = name.charAt(i)-'A';
            int toB = 'Z'-name.charAt(i)+1;
            move[i] = Math.min(toA,toB);
        }
        answer += move[0];
        move[0]=0;
        nowIndex = 0;
        int a = 0 ;
        while(!((a = findZero()) == 0)){
            answer += a;
        }
        return answer;
    }
    public int findZero(){
        int down = nowIndex;
        int up = nowIndex;
        int count = 0;
        boolean flag = false;

        for (int i = 1; i < move.length; i++) {
            up++;
            down--;
            count++;
            if(up== move.length){
                up = 0;
            }
            if(down<0){
                down = move.length-1;
            }
            if(move[up]!=0){
                count += move[up];
                move[up] = 0;
                nowIndex = up;
                flag = true;
                break;
            }
            if(move[down]!=0){
                count += move[down];
                move[down] = 0;
                nowIndex = down;
                flag = true;
                break;
            }
        }

        return flag ? count : 0;
    }

    public static void main(String[] args) {
        String name= "JEROEN";

        System.out.println(new JoyStick().solution(name));
        System.out.println(move.length);
    }
}
