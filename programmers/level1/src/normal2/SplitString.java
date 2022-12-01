package normal2;

public class SplitString {
    public int solution(String s) {
        int answer = 0;
        int countX = 0;
        int countNotX = 0;
        char first = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if(first==s.charAt(i)){
                countX++;
            }else{
                countNotX++;
            }
            System.out.println("countX = " + countX);
            System.out.println("countNotX = " + countNotX);
            if(countX==countNotX){
                if(i != s.length()-1){
                    first = s.charAt(i+1);
                }
                answer++;
                System.out.println("i = " + i);
                countX = 0;
                countNotX = 0;
            }
        }
        if(countX != 0||countNotX != 0){
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        SplitString splitString = new SplitString();
        splitString.solution("banana");
    }
}
