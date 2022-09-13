/*
https://school.programmers.co.kr/learn/courses/30/lessons/12979
        Summer/Winter Coding(~2018)
        기지국 설치
*/
package summer_winter;

public class InstallationBaseStation {
    int start = 0;
    int answer = 0;
    int d;

    public int solution(int n, int[] stations, int w) {
        d = 2 * w + 1;
        start -= w;
        for (int station : stations) {
            findBaseStation(station, w);
        }

        findBaseStation(n + w + 1 , w);

        return answer;
    }

    private void findBaseStation(int station, int w) {
        int n = station - start - 2 * w - 1;
        if(n<=0){
            return;
        }
        answer += ( n + (d - 1) ) / d ;
        start = station;
    }

    public static void main(String[] args) {
        InstallationBaseStation installationBaseStation = new InstallationBaseStation();
        int n = 11;
        int[] stations = {4,11};
        int w = 1;

        int answer = installationBaseStation.solution(n, stations, w);
        System.out.println("answer = " + answer);

    }
}
