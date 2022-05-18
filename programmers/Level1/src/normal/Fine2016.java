package normal;

import java.util.Calendar;

public class Fine2016 {
    public static void main(String[] args) {
        new Fine2016().new Solution().solution(5,24);
    }
class Solution {
    public String solution(int a, int b) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016,a-1,b);
        System.out.println(calendar.getTime().toString().substring(0,3).toUpperCase());
        return calendar.getTime().toString().substring(0,3).toUpperCase();
    }
}
}
