import java.util.ArrayList;
import java.util.Scanner;

public class Num2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrLine = new int[8];
        int maxRow = 0;
        int maxRowIdx = 0;
        int maxCol = 0;
        int maxColIdx = 0;
        for (int i = 1; i <= 6; i++) {
            int way = sc.nextInt();
            int line = sc.nextInt();
            arrLine[i]=line;
            if(i%2==0){
                if(maxRow<line){
                    maxRow=line;
                    maxRowIdx = i;
                }
            }else{
                if(maxCol<line) {
                    maxCol=line;
                    maxColIdx = i;
                }
            }
        }
        arrLine[0]=arrLine[6];
        arrLine[7]=arrLine[1];
        int big = maxCol*maxRow;
        int small = Math.abs(arrLine[maxRowIdx-1]-arrLine[maxRowIdx+1])*
                        Math.abs(arrLine[maxColIdx-1]-arrLine[maxColIdx+1]);
        System.out.println((big-small)*n);


    }
}
