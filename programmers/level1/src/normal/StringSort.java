package normal;

import java.util.*;

public class StringSort {
    public static void main(String[] args) {
        char a ='a';
        char b ='b';
        new StringSort().new Solution().solution(new String[]{"ae","be","ce","ae"},1);
    }
    class Solution {
        public String[] solution(String[] strings, int n) {
            String[] temp = strings;
            String[] answer = new String[strings.length];
            TreeSet<Character> charN = new TreeSet<>();
            for (String string : strings) {
                charN.add(string.charAt(n));
            }
            Arrays.sort(temp);
            int idx=0;
            for (Character character : charN) {
                for (String s : temp) {
                    if(character==s.charAt(n)){
                        answer[idx]=s;
                        idx++;
                    }
                }
            }
            /*Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2){
                    if(s1.charAt(n) > s2.charAt(n)) return 1;
                    //같을때 그대로 비교
                    else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
                    else if(s1.charAt(n) < s2.charAt(n)) return -1;
                    else return 0;
                }
            });*/
            return answer;

        }


    }
}
