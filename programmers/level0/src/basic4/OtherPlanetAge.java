package basic4;

import java.util.stream.Collectors;

public class OtherPlanetAge {
    public String solution(int age) {
        return String.valueOf(age).chars().mapToObj(i->String.valueOf((char)(i-'0'+'a'))).collect(Collectors.joining());
    }
}
