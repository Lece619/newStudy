package basic2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Login {
    public String solution(String[] id_pw, String[][] db) {
        Map<String, String> database = Arrays.stream(db).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        return !database.containsKey(id_pw[0]) ? "fail" : database.get(id_pw[0]).equals(id_pw[1]) ? "login" : "wrong pw";
    }
}
