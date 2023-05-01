package basic5;

public class MakeArr {

    public int[] solution(int[] arr) {
        int length = arr.length;
        int idx = 0;
        while(Math.pow(2,idx) < length){
            idx++;
        }
        int[] answer = new int[(int) Math.pow(2,idx)];
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        return answer;

        //return Arrays.copyOf(arr, (int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2))));
    }
}
