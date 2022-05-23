package normal;

public class FindPrimary {
    public static void main(String[] args) {
        System.out.println();
        System.out.println(new FindPrimary().isPrimary(5));

    }
class Solution {
    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n+1; i++) {
            if(isPrimary(i)){
             answer++;
            }
        }
        return answer;
    }

    public boolean isPrimary(int num){
        int a = (int)Math.sqrt(num);
        for (int i = 2; i < a+1; i++) {
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}

    public boolean isPrimary(int num){
        int a = (int)Math.sqrt(num);

        for (int i = 2; i < a+1; i++) {
            if(num%i==0){
                return false;
            }
        }
        System.out.println(a);
        return true;
    }
}
