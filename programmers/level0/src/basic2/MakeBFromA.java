package basic2;


import java.util.ArrayList;
import java.util.stream.*;

public class MakeBFromA {
    public int solution(String before, String after) {

        ArrayList<Character> characters = after.chars().mapToObj(i -> (char) i).collect(Collectors.toCollection(ArrayList::new));

        for (int i = 0; i < before.length(); i++) {
            Character c = before.charAt(i);
            System.out.println("c = " + c);
            System.out.println("characters = " + characters);
            if(characters.contains(c)){
                characters.remove(c);
            }else{
                return 0;
            }
        }
        return characters.size() == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        MakeBFromA makeBFromA = new MakeBFromA();
        makeBFromA.solution("allpe","apple");
    }
}
