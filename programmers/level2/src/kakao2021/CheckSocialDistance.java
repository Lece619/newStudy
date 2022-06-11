//https://programmers.co.kr/learn/courses/30/lessons/81302?language=java
//코딩테스트 연습
//2021 카카오 채용연계형 인턴십
//거리두기 확인하기
package kakao2021;

import kakao2020.ChangeBracket;

import java.util.ArrayList;

public class CheckSocialDistance {
    int[][] temp;
    int[][] temp2;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int n = 0; n < places.length; n++) {

            temp = new int[5][5];
            temp2 = new int[5][5];
            int pNum = 0;
            for (int i = 0; i < 5; i++) {
                String str = places[n][i];
                for (int j = 0; j < 5; j++) {
                    temp[i][j] = str.charAt(j)=='P' ? 0 : str.charAt(j) == 'O' ? 1 : 2 ;
                    temp2[i][j]=temp[i][j];
                    if(temp[i][j]==0){
                        pNum++;
                    }
                }
            }
            answer[n] = pNum == isOk() ? 1 : 0 ;

        }

        System.out.println(answer[0]);
        return answer;
    }

    public int isOk(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(temp[i][j]==0){
                    paintX(i,j,0,i,j);

                    for (int[] ints : temp) {
                        System.out.println(   );
                        for (int anInt : ints) {
                            System.out.print("   "+anInt);
                        }
                    }
                    System.out.println();
                    System.out.println();
                }
            }
        }
        int pNum = 0;
        for (int[] ints : temp) {
            for (int anInt : ints) {
                if(anInt==0){
                    pNum++;
                }
            }
        }
        return pNum;
    }

    public void paintX(int x,int y,int step,int oriX,int oriY){
        if(x < 0 || x > 4)
            return;
        if(y < 0 || y > 4)
            return;
        if(step == 3)
            return;
        if(step!=0 && temp[x][y]==2)
            return;
        temp[x][y] = 3;
        if(x==oriX&&y==oriY){
            temp[x][y]=0;
        }
        paintX(x - 1,y,step+1,oriX,oriY);
        paintX(x + 1,y,step+1,oriX,oriY);
        paintX(x ,y - 1,step+1,oriX,oriY);
        paintX(x ,y + 1,step+1,oriX,oriY);
    }


    public static void main(String[] args) {
        String[][] arr = {{"POPOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}};
        //String[][] arr = {{"PX","XP"}};
        new CheckSocialDistance().solution(arr);
    }
}
