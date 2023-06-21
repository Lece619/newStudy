package basic6;

import java.util.stream.IntStream;

public class ChangeStringArr {
    public String[] solution(String[] strArr) {
        return IntStream.range(0, strArr.length).mapToObj(i ->{
            if(i % 2 == 1){
                return strArr[i].toUpperCase();
            }
            return strArr[i].toLowerCase();
        }).toArray(String[]::new);
    }
}
