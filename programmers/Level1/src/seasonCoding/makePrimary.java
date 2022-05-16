package seasonCoding;

public class makePrimary {

}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        // 50 C 3 = 50! / 3! 47! => x
//i = 0 j = 1 k = 2
        for (int i = 0; i < nums.length-2; i++) {

            for (int j = i+1; j < nums.length-1; j++) {

                for (int k = j+1; k < nums.length; k++) {

                    int total = nums[i] + nums[j] + nums[k];
                    if(check(total)){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public static boolean check (int total){
        for (int i = 2; i < total; i++) {
            if(total % i == 0)
                return false;
        }
        return true;
    }
}