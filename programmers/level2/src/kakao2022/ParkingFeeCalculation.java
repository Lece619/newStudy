package kakao2022;

import java.util.*;

public class ParkingFeeCalculation {

    HashMap<String, Integer> parkingTime = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {

        makeTime(records);
        ArrayList<String> carNum = new ArrayList<>(parkingTime.keySet());
        Collections.sort(carNum);
        int[] answer = new int[carNum.size()];
        int idx = 0;
        for (String s : carNum) {
            int minute = parkingTime.get(s);
            answer[idx++] = makeFee(minute, fees);
        }

        return answer;
    }

    private int makeFee(int minute, int[] fees) {
        int targetMinute = minute - fees[0];
        int multiFee = targetMinute / fees[2];

        if(targetMinute <= 0){
            return fees[1];
        }

        if(targetMinute % fees[2] != 0){
            multiFee++;
        }


        return fees[1] + multiFee * fees[3];
    }

    private void makeTime(String[] records) {
        for (int i = records.length - 1; i >= 0; i--) {
            String[] record = records[i].split(" ");

            if(!parkingTime.containsKey(record[1])){
                if(record[2].equals("IN")){
                    parkingTime.put(record[1], makeMinute("23:59", "OUT"));
                }
            }
            parkingTime.put(record[1], parkingTime.getOrDefault(record[1],0) + makeMinute(record[0], record[2]));
        }
    }

    private Integer makeMinute(String s, String s1) {
        int minute = Integer.parseInt(s.substring(0,2)) * 60 + Integer.parseInt(s.substring(3,5));
        minute = s1.equals("OUT") ? minute : (minute * (-1));
        return minute;
    }


    //기본 시간(분)	기본 요금(원)	단위 시간(분)	단위 요금(원)
    //180	        5000	         10	        600
    public static void main(String[] args) {
        ParkingFeeCalculation parkingFeeCalculation = new ParkingFeeCalculation();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT" };

        int[] solution = parkingFeeCalculation.solution(fees, records);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
