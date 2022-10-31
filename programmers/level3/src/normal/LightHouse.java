/*
https://school.programmers.co.kr/learn/courses/30/lessons/133500
        연습문제
        등대
*/

package normal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class LightHouse {
    Set<Integer> lightOn = new HashSet<>();

    public int solution(int n, int[][] lighthouse) {
        ArrayList<ArrayList<Integer>> lightHouseConnection = new ArrayList<>();
        IntStream.rangeClosed(0,n).forEach(i->lightHouseConnection.add(new ArrayList<>()));
        for (int[] ints : lighthouse) {
            lightHouseConnection.get(ints[0]).add(ints[1]);
            lightHouseConnection.get(ints[1]).add(ints[0]);
        }

        IntStream.rangeClosed(1, n).filter(i-> lightHouseConnection.get(i).size()==1).forEach(i-> lightOn.add(lightHouseConnection.get(i).get(0)));


        lightHouseConnection.clear();

        while(makeNew(n, lighthouse, lightOn, lightHouseConnection)){
            lightHouseConnection.clear();
        }
        lightOn.remove(0);
        return lightOn.size();
    }

    private boolean makeNew(int n, int[][] lighthouse, Set<Integer> lightOn, ArrayList<ArrayList<Integer>> lightHouseConnection) {
        IntStream.rangeClosed(0, n).forEach(i-> lightHouseConnection.add(new ArrayList<>()));
        int max = 0;
        int idx = 0;

        for (int[] ints : lighthouse) {
            if(!(lightOn.contains(ints[0]) || lightOn.contains(ints[1]))) {

                ArrayList<Integer> arrayList1 = lightHouseConnection.get(ints[0]);
                ArrayList<Integer> arrayList2 = lightHouseConnection.get(ints[1]);
                arrayList1.add(ints[1]);
                arrayList2.add(ints[0]);

            }
        }


        IntStream.rangeClosed(1, n).filter(i-> lightHouseConnection.get(i).size()==1).forEach(i-> lightOn.add(lightHouseConnection.get(i).get(0)));
        for (int[] ints : lighthouse) {
            if(!(lightOn.contains(ints[0]) || lightOn.contains(ints[1]))) {

                ArrayList<Integer> arrayList1 = lightHouseConnection.get(ints[0]);
                ArrayList<Integer> arrayList2 = lightHouseConnection.get(ints[1]);
                arrayList1.add(ints[1]);
                arrayList2.add(ints[0]);

                if(arrayList1.size() > max){
                    max = arrayList1.size();
                    idx = ints[0];
                }
                if(arrayList2.size() > max){
                    max = arrayList2.size();
                    idx = ints[1];
                }
            }
        }

        lightOn.add(idx);
        long count = lightHouseConnection.stream().filter(i -> i.size() != 0).count();
        return count != 0;
    }

    public static void main(String[] args) {
        LightHouse lightHouse = new LightHouse();
        int n = 8;
        int[][] lighthouse = {{1, 2}, {1, 3}, {1, 4}, {1, 5}, {5, 6}, {5, 7}, {5, 8}};
        int solution = lightHouse.solution(n, lighthouse);
        System.out.println("solution = " + solution);
    }
}
