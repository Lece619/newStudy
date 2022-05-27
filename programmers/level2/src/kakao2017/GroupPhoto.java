package kakao2017;

import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/1835  단체사진 찍기
public class GroupPhoto {

    public int solution(int n, String[] data) {
        //{A, C, F, J, M, N, R, T}
        char[] m = {'A','C','F','J','M','N','R','T'};
        int answer = 0;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {

            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HashSet<String> strSet = new HashSet<>();
        strSet.add(String.valueOf(new char[]{'1','2'}));
        strSet.add(String.valueOf(new char[]{'1','2'}));
        strSet.add(String.valueOf(new char[]{'1','2'}));
        strSet.add(String.valueOf(new char[]{'1','2'}));
        strSet.add(new char[]{'1','2'}.toString());
        strSet.add(new char[]{'1','2'}.toString());
        char[] a= {'1','2'};
        System.out.println(strSet);
    }

}
