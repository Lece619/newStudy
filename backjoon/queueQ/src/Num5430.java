import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Num5430 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caseNum = sc.nextInt();
        for (int i = 0; i < caseNum; i++) {
            String func = sc.next();
            int arSize = sc.nextInt();
            String arNum = sc.next().replaceAll("[\\[\\]]","");
            //받은 수를 스트링 숫자 배열로
            String[] arrNum = arNum.split(",");
            Deque<String> deque =new ArrayDeque<>(Arrays.asList(arrNum));
            boolean checkReverse = false;

            if(func.replace("R","").length()>arrNum.length||arSize==0){
                System.out.println("error");
                continue;
            }

            for (int j = 0; j < func.length(); j++) {
                if(func.charAt(j)=='R') {
                    checkReverse = !checkReverse;
                }else{
                    if(checkReverse){
                        deque.pollLast();
                    }else{
                        deque.pollFirst();
                    }
                }
            }
            if(deque.isEmpty()){
                System.out.println("[]");
                continue;
            }
            String result ="[";
            while(!deque.isEmpty()) {
                if(checkReverse){
                    result+=deque.pollLast()+",";
                }else{
                    result+=deque.pollFirst()+",";
                }
            }
            result = result.substring(0,result.length()-1) + "]";
            System.out.println(result);
        }
    }
}
