/*https://school.programmers.co.kr/learn/courses/30/lessons/42890
*코딩테스트 연습
2019 KAKAO BLIND RECRUITMENT - 후보키
* */

package kakao2019;

import java.util.ArrayList;
import java.util.HashSet;

public class CandidateKey {
    //후보키에대한 문제풀이
    ArrayList<String> keySet;
    StringBuilder makeKey2 = new StringBuilder();
    int columnSize;
    public int solution(String[][] relation) {
        int answer = 0;
        columnSize = relation[0].length;
        StringBuilder makeKey = new StringBuilder();
        keySet = new ArrayList<>();

        makeKeySet(0);
        System.out.println(keySet);
        return answer;
    }
    //우선 후보키를 만들고 이름길이에 따라 정렬후 진행 - 할것인가.
    public void makeKeySet(int a){
        System.out.println(makeKey2.toString());
        for (int i = a; i < columnSize; i++) {
            if(makeKey2.indexOf(i+"")!=-1) {
                continue;
            }
            makeKey2.append(i+" ");
            keySet.add(makeKey2.toString());
            makeKeySet(i);
            makeKey2.delete(makeKey2.length()-2,makeKey2.length());
        }
    }
    public static void main(String[] args) {
        CandidateKey test = new CandidateKey();

        String[][] relation = {{"100","ryan","music","2"},
        {"200","apeach","math","2"},
        {"300","tube","computer","3"},
        {"400","con","computer","4"},
        {"500","muzi","music","3"},
        {"600","apeach","music","2"}};

        StringBuilder st = new StringBuilder();
        st.append("sdfs");
        st.delete(st.length()-2,st.length());
        System.out.println(st.toString());
        test.solution(relation);
    }
}
