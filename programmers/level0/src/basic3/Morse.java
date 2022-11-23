package basic3;

import java.util.HashMap;
import java.util.Map;

public class Morse {

    public String solution(String letter) {
        StringBuilder answer = new StringBuilder();
        String morse = " '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e'," +
                "'..-.':'f', '--.':'g','....':'h','..':'i','.---':'j','-.-':'k'," +
                "'.-..':'l', '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r'," +
                "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x','-.--':'y','--..':'z'";
        String[] morseStr = morse.split(",");
        Map<String, String> morseChars = new HashMap<>();
        for (String target : morseStr) {
            String[] split = target.replaceAll("'","").split(":");
            morseChars.put(split[0],split[1]);
            System.out.println(split[0] + " : " + split[1]);
        }
        for (String append : letter.split(" ")) {
            answer.append(morseChars.get(append));
            System.out.println("append = " + append);

        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String morse = " '.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e'," +
                "'..-.':'f', '--.':'g','....':'h','..':'i','.---':'j','-.-':'k'," +
                "'.-..':'l', '--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r', " +
                "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x', '-.--':'y','--..':'z'";


        Morse morse1 = new Morse();
        String letter = ".--. -.-- - .... --- -.";
        System.out.println("morse1.solution(letter) = " + morse1.solution(letter));
    }


}
