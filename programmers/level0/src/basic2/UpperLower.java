package basic2;

import java.util.stream.Collectors;

public class UpperLower {
    public String solution(String my_string) {
        return my_string.chars().mapToObj(i->{
            if( Character.isUpperCase((char)i)){
                return String.valueOf(Character.toLowerCase((char)i));
            }else{
                return String.valueOf(Character.toUpperCase((char)i));
            }
        }).collect(Collectors.joining());
    }
}
