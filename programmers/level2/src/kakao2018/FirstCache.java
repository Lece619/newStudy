/*
https://school.programmers.co.kr/learn/courses/30/lessons/17680
        2018 KAKAO BLIND RECRUITMENT
        [1차] 캐시
*/

package kakao2018;

import java.util.*;

public class FirstCache {
    Queue<String> cache = new LinkedList<>();
    int answer = 0;
    public int solution(int cacheSize, String[] cities) {
        for (String city : cities) {
            city = city.toLowerCase(Locale.ROOT);
            findCity(city , cacheSize);
            System.out.println("city = " + city);
            System.out.println("cache = " + cache);
            System.out.println("answer = " + answer);
        }
        return answer;
    }

    /*캐시 교체 알고리즘은 LRU(Least Recently Used)*/
    private void findCity(String city, int cacheSize) {
        if (cache.contains(city)) {
            answer++;
            cache.remove(city);
        }else{
            answer+=5;
            if(cache.size() == cacheSize){
                cache.poll();
            }
        }
        if(cacheSize!=0) {
            cache.add(city);
        }
    }

    public static void main(String[] args) {
        FirstCache test = new FirstCache();
        int cacheSize = 0;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        int solution = test.solution(cacheSize, cities);
        System.out.println("solution = " + solution);

    }
}
