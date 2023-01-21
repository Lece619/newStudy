/*
https://school.programmers.co.kr/learn/courses/30/lessons/150369
        2023 KAKAO BLIND RECRUITMENT
        택배 배달과 수거하기
*/

package kakao2023;

import java.util.Arrays;
import java.util.Stack;

public class PackageDeliveryAndCollect {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        Stack<Integer> delivery = new Stack<>();
        Arrays.stream(deliveries).forEach(delivery::add);
        Stack<Integer> pickup = new Stack<>();
        Arrays.stream(pickups).forEach(pickup::add);

        int capacity = 0;
        int move = 0;

        while(true){
            if(move == 0){
                capacity = findCapacity(cap, delivery);
            }
            if(!delivery.isEmpty()){
                move = Math.max(move, delivery.size());
                capacity = deliveryBox(capacity, delivery);
            }

            break;

        }
        //로직 생각하기 가장 먼 곳 ?
        // 총 배달 해야할 곳 갯수 회수해야 할 곳 거리


        /*
        한번 더 생각해 볼 필요가 있을듯.

         */
        return answer;
    }

    private int deliveryBox(int capacity, Stack<Integer> delivery) {
        if(delivery.peek() <= capacity){
            return capacity - delivery.pop();
        }

        delivery.add(delivery.pop() - capacity);
        return 0;
    }

    private int findCapacity(int cap, Stack<Integer> delivery) {
        if( delivery.isEmpty() ){
            return 0;
        }
        int sum = delivery.stream().mapToInt(i -> i).sum();
        return Math.max(sum, cap);
    }

    public static void main(String[] args) {
        PackageDeliveryAndCollect packageDeliveryAndCollect = new PackageDeliveryAndCollect();
        int cap = 4;
        int n = 5;
        int[] deliveries = {1, 0, 3, 1, 2};
        int[] pickups = {0, 3, 0, 4, 0};

        packageDeliveryAndCollect.solution(cap, n, deliveries, pickups);
    }
}
