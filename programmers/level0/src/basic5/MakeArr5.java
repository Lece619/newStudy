package basic5;

public class MakeArr5 {
    public int[] solution(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            char nowNum = num == 0? '0' : '1';
            if(sb.length() == 0){
                sb.append(nowNum);
                continue;
            }

            int index = sb.length() - 1;

            if(sb.charAt(index) == nowNum){
                sb.deleteCharAt(index);
                continue;
            }

            sb.append(nowNum);
        }

        int[] answer = sb.toString().chars().map(num-> num - '0').toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }
}
