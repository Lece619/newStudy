//https://programmers.co.kr/learn/courses/30/lessons/17677?language=java
//코딩테스트 연습
//2018 KAKAO BLIND RECRUITMENT
//[1차] 뉴스 클러스터링

package kakao2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/*
 자카드 유사도
예를 들어 집합 A = {1, 2, 3}, 집합 B = {2, 3, 4}라고 할 때, 교집합 A ∩ B = {2, 3},
 합집합 A ∪ B = {1, 2, 3, 4}이 되므로, 집합 A, B 사이의 자카드 유사도 J(A, B) = 2/4 = 0.5가 된다.
 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 J(A, B) = 1로 정의한다.
*/
/*
* 입력으로는 str1과 str2의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
* 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고,
*  기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 예를 들어 "ab+"가 입력으로 들어오면,
*  "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.다중집합 원소 사이를 비교할 때,
* 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.
* */
public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        for (int i = 0; i < str1.length()-1; i++) {
            if(Pattern.matches("^[A-Z]*$",str1.substring(i,i+2)))
                list1.add(str1.substring(i,i+2));
        }
        for (int i = 0; i < str2.length()-1; i++) {
            if(Pattern.matches("^[A-Z]*$",str2.substring(i,i+2)))
                list2.add(str2.substring(i,i+2));
        }
        double cross=0;
        double sum=0;
        for (String s : list2) {
            if(list1.contains(s)){
                cross++;
                list1.remove(s);
            }
        }
        sum=list1.size()+list2.size();
        if(sum==0){
            return 65536;
        }else{
            return (int)(cross/sum*65536);
        }
    }

    public static void main(String[] args) {
        System.out.println(new NewsClustering().solution("aa1+aa2","AAAA12"));
    }
}
