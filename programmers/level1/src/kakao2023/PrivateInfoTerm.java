/*
https://school.programmers.co.kr/learn/courses/30/lessons/150370
        2023 KAKAO BLIND RECRUITMENT
        개인정보 수집 유효기간
*/

package kakao2023;

import java.util.*;

public class PrivateInfoTerm {
    public int[] solution(String today, String[] terms, String[] privacies) {

//        28일 모든 달
        Map<String, Long> limitDays = new HashMap<>();
        Arrays.stream(terms)
                .map(i->i.split(" "))
                .forEach(i->limitDays.put(i[0], Long.parseLong(i[1]) * 28 ));
        long todayDays = makeDaysByFormat(today);

        List<Integer> removePrivacyNum = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            long limitDay = makeDaysByFormat(privacy[0]) + limitDays.get(privacy[1]);
            if(limitDay <= todayDays){
                removePrivacyNum.add(i+1);
            }
        }
        int[] answer = removePrivacyNum.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    private long makeDaysByFormat(String formattedDay) {
        long[] yyyymmdd = Arrays.stream(formattedDay.split("\\.")).mapToLong(Long::parseLong).toArray();
        return ( yyyymmdd[0] * 12 + yyyymmdd[1] ) * 28 + yyyymmdd[2];
    }

    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        PrivateInfoTerm privateInfoTerm = new PrivateInfoTerm();
        int[] solution = privateInfoTerm.solution(today, terms, privacies);
        for (int i : solution) {
            System.out.println(i);
        }

        KakaoBuilder kakao = KakaoBuilder.getInstance().setId(1).setName("name");
    }
}

class KakaoBuilder{
    int id;
    String name;

    private static final KakaoBuilder KAKAO_BUILDER = new KakaoBuilder();

    private KakaoBuilder() {

    }

    public KakaoBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public KakaoBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public static KakaoBuilder getInstance(){
        return KAKAO_BUILDER;
    }

    public void printId(){
        System.out.println("id = " + id);
    }

}
