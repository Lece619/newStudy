package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class FindPrimary {
    ArrayList<Character> list;
    HashSet<Integer> set = new HashSet<>();
    String str = "";

    int count = 0;
    public int solution(String numbers) {
        char[] chars = numbers.toCharArray();
        list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        makeMap(list);
        set.remove(1);
        set.remove(0);
        System.out.println(set);


        for (Integer integer : set) {
            if(checkPri(integer)){
                count++;
            }
        }

        return count;
    }
    public ArrayList<Character> makeMap(ArrayList<Character> list){
        /*if(list.isEmpty()){
            set.add(Integer.parseInt(str));
        }else{*/
        int size = list.size();
            for(int i = 0; i < size; i++){
                Collections.sort(list);

                Character temp = list.remove(i);
                String tempString = str;
                str+=temp;
                set.add(Integer.parseInt(str));
                makeMap(list);
                str=tempString;

                list.add(temp);
            }
//        }
        return list;
    }
    public boolean checkPri(int num){
        int a = (int)Math.sqrt(num);
        for (int i = 2; i < a+1; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println(new FindPrimary().solution("011"));
    }
}
