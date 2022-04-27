import java.util.*;

public class Num2675 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num =sc.nextInt();
        sc.nextLine();
        for(int i =0; i<num;i++){
            String[] str=sc.nextLine().split(" ");
            int reNum=Integer.parseInt(str[0]);
            for(int j =0;j<str[1].length();j++){
                for(int k=0;k<reNum;k++)
                    System.out.print(str[1].charAt(j));
            }
            System.out.println();
        }

    }
}
