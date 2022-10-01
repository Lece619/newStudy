package basic;

public class FindSeven {
    public int solution(int[] array) {
        int answer = 0;
        for (int i : array) {
            String s = i + "";
            String s2 = s.replaceAll("7", "");
            answer += s.length() - s2.length();
        }
        return answer;
    }

    public static void main(String[] args) {
        FindSeven findSeven = new FindSeven();
        System.out.println("findSeven = " + findSeven.solution(new int[]{7,77,7}));
    }
}
