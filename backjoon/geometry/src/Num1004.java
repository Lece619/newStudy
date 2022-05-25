import java.util.Scanner;

public class Num1004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testSize = sc.nextInt();
        for (int i = 0; i < testSize; i++) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            int count = 0 ;

            int planetarySystemSize = sc.nextInt();



            for (int j = 0; j < planetarySystemSize; j++) {
                double centerX = sc.nextDouble();
                double centerY = sc.nextDouble();
                double r = Math.pow(sc.nextDouble(),2);
                if(x1==x2 && y1 == y2){
                    continue;
                }
                //각 지점이 중심과의 거리가 반지름보다 작으면 = 두 점이 원 내부위치.
                if(r > Math.pow(x1-centerX,2)+Math.pow(y1-centerY,2)
                        && r > Math.pow(x2-centerX,2)+Math.pow(y2-centerY,2)){
                    //각 지점이 중심과의 거리가 반지름 보다 클경우 = 두점이 원 외부위치 조사필요.
                }else if(r < Math.pow(x1-centerX,2)+Math.pow(y1-centerY,2)
                        && r < Math.pow(x2-centerX,2)+Math.pow(y2-centerY,2)){
                    //각 지점이 중심과의 거리가 반지름 보다 클경우 = 두점이 원 외부위치 조사필요.
                }else{
                    count++;
                }


            }
            //결과출력
            System.out.println(count);
        }
    }
}
