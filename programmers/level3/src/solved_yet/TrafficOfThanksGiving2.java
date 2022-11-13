/*
https://school.programmers.co.kr/learn/courses/30/lessons/17676
        2018 KAKAO BLIND RECRUITMENT
        [1차] 추석 트래픽
*/

package solved_yet;

public class TrafficOfThanksGiving2 {


    public int solution(String[] lines) {
        int answer = 0;

        return answer;
    }
    

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        TrafficOfThanksGiving2 trafficOfThanksGiving = new TrafficOfThanksGiving2();
        int solution = trafficOfThanksGiving.solution(lines);
        System.out.println("solution = " + solution);
    }
}
