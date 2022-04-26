import java.util.HashMap;
import java.util.Scanner;

//해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다.
// 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다.
// 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?
//----input
//2
//3
//hat headgear
//sunglasses eyewear
//turban headgear
//3
//mask face
//sunglasses face
//makeup face

//-----output
//5
//3
public class Num9375 {
    public static void main(String[] args) {
       Scanner sc =new Scanner(System.in);
       int num=sc.nextInt();
       for(int i=0;i<num;i++) {
           int result = 1;
           int m = sc.nextInt();
           HashMap<String, Integer> map = new HashMap<>();
           String[] item = new String[2];
           sc.nextLine();
           for (int j = 0; j < m; j++) {
               item = sc.nextLine().split(" ");
               /*
               ! new !
                use this code in next
                not use if just
                map.put(item[1], map.getOrDefault(item[1], 0) + 1);
               */
               if (!map.containsKey(item[1])) {
                   map.put(item[1], 1);
               } else {
                   map.replace(item[1], map.get(item[1]) + 1);
               }

           }
           for (String key : map.keySet()) {
               result *= (map.get(key) + 1);
           }
           System.out.println(result - 1);
       }
    }
}
