package basic7;

public class ChangeUpper {
    public String solution(String my_string, String alp) {
        return my_string.replace(alp, alp.toUpperCase());
    }

    //sum odd and even
    public int solution(int[] num_list) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) {
                odd += num_list[i];
            } else {
                even += num_list[i];
            }
        }
        return Math.max(odd, even);
    }
}
