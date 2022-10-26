package helponboard;

import java.util.*;
import java.util.stream.Collectors;

public class ErrorId {

    public static List<String> solution(List<List<String>> forms){

        Map<String, Integer> errorMap = new HashMap<>();

        for (List<String> form : forms) {

            Set<String> set = new HashSet<>();
            String nickName = form.get(1);
            StringBuilder sb = new StringBuilder();

            sb.append(nickName.charAt(0));

            for (int i = 1; i < nickName.length(); i++) {
                sb.append(nickName.charAt(i));
                String nowString = sb.toString();
                if(!set.contains(nowString)) {
                    errorMap.put(nowString, errorMap.getOrDefault(nowString, 0) + 1);
                    set.add(nowString);
                }
                sb.deleteCharAt(0);
            }

            set.clear();

        }

        Set<String> collect = errorMap.entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toSet());

        List<String> answerList = new ArrayList<>();

        for (List<String> form : forms) {
            String str = form.get(1);

            for (String key : collect) {
                if(str.contains(key)){
                    answerList.add(form.get(0));
                    break;
                }
            }
        }


        return answerList;
    }

    public static void main(String[] args) {
        List<List<String>> forms = List.of(
                List.of("esdafa@naver.com", "제이제이야이"),
                List.of("esda213fa@naver.com", "제제제제이"),
                List.of("e122a@naver.com", "제비비비비이"));

        List<String> solution = solution(forms);
        System.out.println("solution = " + solution);
    }
}
