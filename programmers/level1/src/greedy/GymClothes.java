package greedy;

public class GymClothes {
    class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = n;
            //0 ~ n+1 까지 배열 선언
            int[] clothes = new int[n+2];
            for (int i : lost) {
                clothes[i]--;
            }
            for (int i : reserve) {
                clothes[i]++;
            }
            for(int i = 1; i<n+1; i++){
                //체육복이 없을때
                if(clothes[i]==-1){
                    //앞, 뒤 확인
                    if(clothes[i-1]==1){
                        clothes[i-1]=0;
                        clothes[i]=0;
                    }else if(clothes[i+1]==1){
                        clothes[i+1]=0;
                        clothes[i]=0;
                    }
                }
            }
            for (int clothe : clothes) {
                if(clothe==-1){
                    answer+=clothe;
                }
            }

            return answer;
        }
    }
}
