import java.util.Scanner;

public class Num10809 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String word=sc.next();
        int num=(int)'z'-(int)'a'+1;
        int[] checkList=new int[num];
        for (int i = 0; i < checkList.length; i++) {
            checkList[i]=-1;
        }
        for(int i =0;i<word.length();i++){
            int location=(int)word.charAt(i)-(int)'a';
            if(checkList[location]==-1) {
                checkList[location]=i;
            }
        }
        for(int i = 0 ;i<checkList.length;i++){
            System.out.print(checkList[i]+" ");
        }
    }
}