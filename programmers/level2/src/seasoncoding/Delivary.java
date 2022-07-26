//https://school.programmers.co.kr/learn/courses/30/lessons/12978
//코딩테스트 연습 Summer/Winter Coding(~2018) 배달
package seasoncoding;


public class Delivary {

    boolean[] check;
    int[] town;

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        town = new int[N+1];
        for (int i = 0; i < town.length; i++) {
            town[i] = Integer.MAX_VALUE;
        }
        check = new boolean[N + 1];
        town[1] = 0;
        int start = 1;
        for (int i = 1; i < N + 1; i++) {
            check[start] = true;
            int nextStart = 0;
            for (int[] ints : road) {
                int nextMin = Integer.MAX_VALUE;
                int target = 0;
                if (ints[0] == start) {
                    target = ints[1];
                } else if (ints[1] == start){
                    target = ints[0];
                }
                if(target != 0) {
                    town[target] = Math.min(town[target], (ints[2] + town[start]));
                    if(town[target] < nextMin && check[target] == false){
                        nextStart = target;
                    }
                }
            }
            if(nextStart==0){
                int nextMin = Integer.MAX_VALUE;
                for (int j = 0; j < check.length; j++) {
                    if(!check[j]){
                        if(town[j]<nextMin){
                            nextMin = town[j];
                            nextStart = j;
                        }
                    }
                }
            }
            start = nextStart;
        }

        for (int i = 0; i < town.length; i++) {
            int i1 = town[i];
            if(i1 <= K){
                answer++;
            }
        }

        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        int[][] road = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int N = 6;
        int K = 4;

        Delivary test = new Delivary();
        test.solution(N, road, K);
    }
}
