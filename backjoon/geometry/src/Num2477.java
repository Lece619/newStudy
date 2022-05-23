import java.util.Scanner;

public class Num2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        
        
        //틀림
//        int[] wayLength = new int[4];
//        int[] smallBox= new int[2];
//        int temp=0;
//        for (int i = 0; i < 6; i++) {
//            int way = sc.nextInt()-1;
//            int leng = sc.nextInt();
//
//            if(wayLength[way]==0){
//                wayLength[way]=leng;
//                temp=leng;
//            }else{
//                if(smallBox[0]==0) {
//                    smallBox[0] = temp;
//                    smallBox[1] = leng;
//                }
//            }
//        }
//        int bigBoxSize = Math.max(wayLength[0],wayLength[1]) * Math.max(wayLength[2],wayLength[3]);
//        int smallBoxSize = smallBox[0] * smallBox[1];
//        System.out.println((bigBoxSize-smallBoxSize)*n);
    }
}
