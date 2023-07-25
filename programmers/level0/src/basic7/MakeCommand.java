package basic7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MakeCommand {

    Map<Integer, String> commmand = new HashMap<>();
    public String solution(int[] numLog) {

        commmand.put(1, "w");
        commmand.put(-1, "s");
        commmand.put(10, "d");
        commmand.put(-10, "a");

        int[] commandLog = new int[numLog.length - 1];
        for (int i = 0; i < commandLog.length; i++) {
            commandLog[i] = numLog[i + 1] - numLog[i];
        }
        return Arrays.stream(commandLog).mapToObj(i -> commmand.get(i)).collect(Collectors.joining());
    }
}
