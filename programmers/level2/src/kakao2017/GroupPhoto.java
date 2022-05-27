package kakao2017;

import java.util.ArrayList;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/1835  단체사진 찍기
public class GroupPhoto {

    public String[] m = {"A","C","F","J","M","N","R","T"};

    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<String> totalList =new ArrayList<>();
    public int solution(int n, String[] data) {
        //{A, C, F, J, M, N, R, T}
        int answer = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {

            }
        }
        return answer;
    }
    public  void makeSet(){
        if(list.size()==m.length){
            System.out.println(list.toString().replaceAll("[\\[\\], ]",""));
            totalList.add(list.toString().replaceAll("[\\[\\], ]",""));
            System.out.println(list);
        }else{
            for (int i = 0; i < m.length; i++) {
                if(!list.contains(m[i])){
                    list.add(m[i]);
                    makeSet();
                    list.remove(m[i]);
                }
            }
        }
    }


    public static void main(String[] args) {
        new GroupPhoto().makeSet();
        System.out.println(totalList);
        System.out.println(totalList.size());
    }

}
