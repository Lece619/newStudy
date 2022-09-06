/*
https://school.programmers.co.kr/learn/courses/30/lessons/17686
        2018 KAKAO BLIND RECRUITMENT
        [3차] 파일명 정렬
*/

package kakao2018;

import java.util.*;

public class SortByFileName {
    public String[] solution(String[] files) {
        String[] answer = {};


        ArrayList<String> fileList = new ArrayList<>(Arrays.asList(files));
        fileList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1.toLowerCase();
                String str2 = o2.toLowerCase();
                String str1change = str1.split("\\d")[0];

                int str1Num = makeNum(str1, str1change.length());
                String str2change = str2.split("\\d")[0];
                int str2Num = makeNum(str2, str2change.length());
                int compare1 = str1change.compareToIgnoreCase(str2change);
                if(compare1 == 0){
                    return str1Num - str2Num ;
                }
                return compare1;
            }
        });
        int idx = 0;
        for (String s : fileList) {
            files[idx++] = s;
        }
        return files;
    }

    private int makeNum(String str, int length) {
        String result = "";
        for (int i = length; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                result += c;
            }else{
                break;
            }
        }
        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        SortByFileName sortByFileName = new SortByFileName();
        String[] files = {"img12.png", "img10as1.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        sortByFileName.solution(files);
        for (String file : files) {
            System.out.println("file = " + file);
        }


    }
}
