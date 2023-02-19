/*
https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java
        연습문제
        호텔 대실
*/

package normal2;

import java.util.Arrays;

public class BookHotel {

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] timeSheet = new int[60 * 24 + 10];

        for (String[] time : book_time) {

            int startTime = changeMin(time[0]);
            int endTime = changeMin(time[1]) + 10;

            makeTimeSheet(startTime, endTime, timeSheet);

        }
        return Arrays.stream(timeSheet).max().getAsInt();
    }

    private void makeTimeSheet(int startTime, int endTime, int[] timeSheet) {
        for (int i = startTime; i < endTime; i++) {
            timeSheet[i]++;
        }
    }

    private int changeMin(String time) {
        String[] hourMin = time.split(":");
        return Integer.parseInt(hourMin[0]) * 60 + Integer.parseInt(hourMin[1]);
    }

    public static void main(String[] args) {
        BookHotel bookHotel = new BookHotel();
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int solution = bookHotel.solution(book_time);
        System.out.println(solution);
    }
}
