import java.util.ArrayList;
import java.util.Scanner;

public class Num2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] order = {4,3,1,2};
        int[] wayLen = new int[4];
        int temp=0;
        int nextWay=0;
        int smallBox=0;
        int[][] oror = {{4,2,3,1},{2,3,1,4},{3,1,4,2},{1,4,2,3}};

        for (int i = 0; i < 6; i++) {
            int way = sc.nextInt();
            int len = sc.nextInt();
            wayLen[way-1]=len;
            if(i==0||way==nextWay) {
                temp = len;
            }else if(way!=nextWay){
                smallBox=temp*len;
            }
            nextWay = order[way - 1];
        }
        int big= Math.max(wayLen[0],wayLen[1])*Math.max(wayLen[2],wayLen[3]);
//        System.out.println(big+"  "+smallBox);
        System.out.println((big-smallBox)*n);
    }
}
