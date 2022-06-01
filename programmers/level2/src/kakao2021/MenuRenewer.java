//https://programmers.co.kr/learn/courses/30/lessons/72411
//프로그래머스 - 코딩테스트 연습
//2021 KAKAO BLIND RECRUITMENT
//메뉴 리뉴얼

package kakao2021;

import java.util.*;

public class MenuRenewer {
    static HashSet<String> menuSet= new HashSet<>();
    static int cnt=0;
    public String[] solution(String[] orders, int[] course) {
        menuSet = new HashSet<>();
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> answerList = new ArrayList<>();
        for (String order : orders) {
            menuSet = new HashSet<>();
            makeSet(order,0,order.length(),"");
            for (String s : menuSet) {
                char[] c = s.toCharArray();
                Arrays.sort(c);
                s=String.valueOf(c);
                map.put(s, map.getOrDefault(s,0)+1);
            }
        }
        int[] orderNum = new int[21];
        for (String s : map.keySet()) {
            for (int i : course) {
                if(s.length()==i && map.get(s)>1){
                    orderNum[i]=Math.max(orderNum[i],map.get(s));
                }
            }
        }
        for(String s : map.keySet()){
            for(int i : course){
                if(s.length()==i && map.get(s)==orderNum[i]){
                    answerList.add(s);
                }
            }
        }
        Collections.sort(answerList);
        String[] answer = answerList.toArray(new String[0]);
        return answer;
    }
    public void makeSet(String order,int n,int range,String s){
        if(n==range){
            return;
        }else{
            String temp = order.charAt(n)+"";
            menuSet.add(s+temp);
            makeSet(order,n+1,range,s+temp);
            makeSet(order,n+1,range,s);
        }
    }

    public static void main(String[] args) {
        MenuRenewer m = new MenuRenewer();
        m.makeSet("ABE",0,3,"");
        m.solution(null,null);

    }

}
