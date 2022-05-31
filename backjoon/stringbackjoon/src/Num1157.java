import java.util.Scanner;

public class Num1157 {
    public static void main(String[] args) {
        String str = new Scanner(System.in).next().toUpperCase();
        int[] numberCheck = new int[26];
        for(int i = 0; i <str.length();i++) {
            int num = str.charAt(i) - 'A';
            numberCheck[num]++;
        }
        int maxNum = 0;
        int idx = 0;
        for (int i = 0; i < numberCheck.length; i++) {
            if( maxNum < numberCheck[i] ){
                maxNum = numberCheck[i];
                idx = i;
            }

        }
        int cnt=0;
        for (int i : numberCheck) {
            if(maxNum == i){
                cnt++;
            }
        }

        if(cnt==1){
            System.out.println((char)('A'+idx));
        }else{
            System.out.println("?");
        }
    }
}
