/*
https://school.programmers.co.kr/learn/courses/30/lessons/118668
        2022 KAKAO TECH INTERNSHIP
        코딩 테스트 공부
*/

package kakao2022;

public class CodingTestStudy2 {

    int[][] aplCop;
    public int solution(int alp, int cop, int[][] problems) {
        aplCop = new int[251][251];
        int targetAlp = 0;
        int targetCop = 0;

        for (int i = alp - 1; i < 250; i++) {
            for (int j = cop - 1; j < 250; j++) {
                aplCop[i+1][j+1] = Math.abs( i - alp - 1 + j - cop -1) ;
            }
        }
        for (int[] problem : problems) {
            targetAlp = Math.max(problem[0],targetAlp);
            targetCop = Math.max(problem[1],targetCop);
        }

        int algo = alp + 1;
        int code = cop + 1;

        while(algo < targetAlp+1 && code < targetCop+1){

            algo = Math.min(targetAlp+1, algo);
            code = Math.min(targetCop+1, code);

            aplCop[algo][code] = Math.min(aplCop[algo][code],aplCop[algo][code-1] + 1);
            aplCop[algo][code] = Math.min(aplCop[algo][code],aplCop[algo-1][code] + 1);
            makeArrs(algo, code, problems);

            aplCop[algo][code+1] = Math.min(aplCop[algo][code+1],aplCop[algo][code] + 1);
            aplCop[algo][code+1] = Math.min(aplCop[algo][code+1],aplCop[algo-1][code+1] + 1);
            makeArrs(algo, code+1, problems);

            aplCop[algo+1][code] = Math.min(aplCop[algo+1][code],aplCop[algo+1][code-1] + 1);
            aplCop[algo+1][code] = Math.min(aplCop[algo+1][code],aplCop[algo][code] + 1);
            makeArrs(algo+1, code, problems);

            algo++;
            code++;
        }

        return aplCop[Math.max(alp+1,targetAlp+1)][Math.max(cop+1,targetCop+1)];
    }

    private void makeArrs(int alp, int cop, int[][] problems) {
        for (int[] problem : problems) {
            if(alp < problem[0] || cop < problem[1]){
                continue;
            }
            aplCop[alp + problem[2]][cop + problem[3]] = Math.min(aplCop[alp + problem[2]][cop + problem[3]]
                                                                    , aplCop[alp][cop] + problem[4]);
        }
    }

    public static void main(String[] args) {
        int alp = 10;
        int cop = 10;
        int[][] problems = {{10,15,2,1,2},{20,20,3,3,4}};

        CodingTestStudy2 codingTestStudy = new CodingTestStudy2();
        System.out.println("codingTestStudy.solution(alp, cop, problems) = " + codingTestStudy.solution(alp, cop, problems));
    }
}
