package kakao2020;

import java.sql.Statement;
import java.util.*;

public class StringCompression {
    public int solution(String s) {
        int answer = 0;
        if(s.length()==1){
            return 1;
        }
        int limitLen = s.length()/2;// 4 - 2  5 - 2
        HashSet<Integer> lenSet = new HashSet<>();
        for (int i = 1; i <= limitLen; i++) {
            String temp = s;
            List<String> set = new LinkedList<>();

            for (int j = 0; j < s.length()-i; j++) {
                set.add(s.substring(j,j+i));
            }
            //길이가 1일때 .
            String changeString = "";
            System.out.println(set);
            for (String s1 : set) {
                changeString=s1+s1;
                int num=0;
                while(true) {
                    String subTemp = temp.replaceAll(changeString,s1);
                    if(subTemp.equals(temp)){
                        temp=temp+""+num;
                        break;
                    }else{
                        num++;
                        temp=subTemp;
                    }
                }
            }
            lenSet.add(temp.replace("0","").length());
            System.out.println(temp);
        }
        System.out.println(Collections.min(lenSet));
        return Collections.min(lenSet);
    }

    public static void main(String[] args) {
        System.out.println("xababcdcdababcdcd");
        new StringCompression().solution("xababcdcdababcdcd");
    }
}
