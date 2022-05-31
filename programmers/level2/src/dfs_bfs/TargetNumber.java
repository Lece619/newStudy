//https://programmers.co.kr/learn/courses/30/lessons/43165
//프로그래머스 - 타겟 넘버
package dfs_bfs;

public class TargetNumber {

    int answer=0;
    public int solution(int[] numbers, int target) {

        answer = 0;
        dfs(0,0,target,numbers);
        System.out.println(answer);
        return answer;
    }
    public void dfs(int sum,int n,int target,int[] numbers){
        if(n==numbers.length){
            if(sum==target){
                answer++;
            }
        }else{
            dfs(sum+numbers[n],n+1,target,numbers);
            dfs(sum-numbers[n],n+1,target,numbers);
        }
    }

    public static void main(String[] args) {
        new TargetNumber().solution(new int[]{1, 1, 1, 1, 1},3);
    }
}
