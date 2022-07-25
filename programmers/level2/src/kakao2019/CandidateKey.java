/*https://school.programmers.co.kr/learn/courses/30/lessons/42890
*코딩테스트 연습
2019 KAKAO BLIND RECRUITMENT - 후보키
* */

package kakao2019;

import java.util.*;

public class CandidateKey {
    //후보키에대한 문제풀이
    ArrayList<String> keySet;
    ArrayList<String> realKey;
    StringBuilder makeKey2 = new StringBuilder();
    int columnSize;
    int rowSize;

    public int solution(String[][] relation) {
        int answer = 0;
        columnSize = relation[0].length;
        rowSize = relation.length;
        StringBuilder makeKey = new StringBuilder();
        keySet = new ArrayList<>();
        realKey = new ArrayList<>();


        makeKeySet(0);
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        //keySet 으로 확인하기
        confirmKey(relation);

        return realKey.size();
    }

    //우선 후보키를 만들고 이름길이에 따라 정렬후 진행 - 할것인가.
    public void makeKeySet(int a) {
        for (int i = a; i < columnSize; i++) {
            if (makeKey2.indexOf(i + "") != -1) {
                continue;
            }
            makeKey2.append(i + " ");
            keySet.add(makeKey2.toString().trim());
            makeKeySet(i);
            makeKey2.delete(makeKey2.length() - 2, makeKey2.length());
        }
    }

    public void confirmKey(String[][] relation) {

        for (String s : keySet) {
            if(!checkMin(s)){
                continue;
            }
            Set<String> set = new HashSet<>();
            String[] key = s.split(" ");
            for (String[] strings : relation) {
                String result = "";
                
                for (String s1 : key) {
                    result += strings[Integer.parseInt(s1)] + " ";
                }
                
                if(set.contains(result)) {
                    break;
                }else{
                    set.add(result);
                }
            }
            if(set.size()==rowSize){
                realKey.add(s);
            }
        }
    }

    public boolean checkMin(String key){
        Set<String> nowKey = new HashSet<>(Arrays.asList(key.split(" ")));
        for (String s : realKey) {
            Set<String> check = new HashSet<>(Arrays.asList(s.split(" ")));
            if(nowKey.containsAll(check)){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        CandidateKey test = new CandidateKey();

        String[][] relation = {{"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}};

        test.solution(relation);
    }
}
