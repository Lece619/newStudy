import java.util.Scanner;

public class Num1358 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double width = sc.nextInt();
        double hight = sc.nextInt();
        double r = hight/2;
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        int num = sc.nextInt();
        int count = 0;
        for (int i = 0; i < num; i++) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
           if( x1 >= x && x1 <= x+width){
               if( y1 >= y && y1 <= y + hight){
                   count++;
                   System.out.println(x1+"  "+y1+" 사각형");
               }
           }else{
               if( x1 > x+width){
                   x1 -= width;
               }
               System.out.println();
               System.out.println(x1+"  "+y1);
               System.out.println(Math.pow(r,2));
               System.out.println(Math.pow(x1-x,2)+Math.pow(y1-y-r,2));
               if( Math.pow(r,2) >= Math.pow(x1-x,2)+Math.pow(y1-r-y,2)){
                   count++;

                   System.out.println(x1+"  "+y1+" 원");
               }
           }
        }
        System.out.println(count);
    }
}
