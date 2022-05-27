package kakao2017;
//https://programmers.co.kr/learn/courses/30/lessons/1829 카카오 프렌즈 컬러링 북
public class ColoreringBook {
    //static int[][] tempPicture;
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] tempPicture = new int[m + 2][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tempPicture[i+1][j+1]=picture[i][j];
            }
        }
        int area = 0;
        for (int i = 1 ; i < m+1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int check = checkArea(i,j,tempPicture[i][j],tempPicture);
                if(check!=0){
                    maxSizeOfOneArea=Math.max(check,maxSizeOfOneArea);
                    numberOfArea++;
                }
//                System.out.print(i+" , "+j +" : ");
//                System.out.println(checkArea(i,j,tempPicture[i][j],0));
            }
        }
        int[] answer = new int[2];


        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        for (int[] ints :picture) {

            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
        System.out.println("num :" + numberOfArea);
        System.out.println(maxSizeOfOneArea);
        return answer;
    }
    public static int checkArea(int x, int y,int n,int[][] temp){
        if(n==0) {
            return 0;
        }else{
            if(temp[x][y]==n) {
                temp[x][y]=0;
                return 1 + checkArea(x + 1, y, n, temp) + checkArea(x, y + 1, n, temp)
                        +checkArea(x, y-1, n, temp) + checkArea(x-1, y, n, temp);
            }
            return 0;
        }
    }

    //Test Main
    public static void main(String[] args) {
        int[][] picture = {{1,2},{2,2}};
        new ColoreringBook().solution(2,2,picture);

    }
}

