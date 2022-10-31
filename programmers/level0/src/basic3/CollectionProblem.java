package basic3;
import java.util.LinkedList;

public class CollectionProblem {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        int option = 0;
        int idx = 0;
        switch (direction){
            case "right" :
                answer[0] = numbers[numbers.length - 1];

                idx++;
                break;
            case "left" :
                answer[numbers.length - 1] = numbers[0];
                option++;
                break;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            answer[idx++] = numbers[i + option];
        }

        return answer;
    }

    public static void main(String[] args) {
        CollectionProblem collectionProblem = new CollectionProblem();
        int[] rights = collectionProblem.solution(new int[]{1, 2, 3}, "right");
        for (int right : rights) {
            System.out.println(right);
        }
    }
}
