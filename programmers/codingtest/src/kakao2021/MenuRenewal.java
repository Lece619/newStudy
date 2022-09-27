/*
https://school.programmers.co.kr/learn/courses/30/lessons/72411
        2021 KAKAO BLIND RECRUITMENT
        메뉴 리뉴얼
*/

package kakao2021;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MenuRenewal {

    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> answer = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public String[] solution(String[] orders, int[] course) {

        for (int i : course) {
            map.clear();
            for (String order : orders) {
                String word = changOrder(order);
                makeCourseMap(word, i, 0);
            }

            Integer max = map.isEmpty() ? 0 : Collections.max(map.values());
            if( max >= 2) {
                for (String s : map.keySet()) {
                    if (map.get(s) == max) {
                        answer.add(s);
                    }
                }
            }
        }
        Collections.sort(answer);
        String[] strings = answer.toArray(new String[0]);
        return strings;
    }

    private String changOrder(String order) {

        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < order.length(); i++) {
            characters.add(order.charAt(i));
        }
        Collections.sort(characters);
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character);
        }
        return sb.toString();
    }

    private void makeCourseMap(String order, int courseLength, int idx) {
        if (sb.length() == courseLength) {
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            return;
        }
        for (int i = idx; i < order.length(); i++) {
            sb.append(order.charAt(i));
            makeCourseMap(order, courseLength, i + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        MenuRenewal menuRenewal = new MenuRenewal();
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,4};
        String[] answer = menuRenewal.solution(orders, course);

        for (String s : answer) {
            System.out.println("s = " + s);
        }

    }
}
