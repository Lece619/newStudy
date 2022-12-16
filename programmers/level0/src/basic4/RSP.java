package basic4;

import java.util.stream.Collectors;

public class RSP {
    public String solution(String rsp) {
        int[] winRSP =new int[6];
        int ROCK = 0;
        int SCISSOR = 2;
        int PAPER = 5;

        winRSP[ROCK] = PAPER;
        winRSP[SCISSOR] = ROCK;
        winRSP[PAPER] = SCISSOR;

        return rsp.chars().mapToObj(i->String.valueOf(winRSP[i-'0'])).collect(Collectors.joining());
    }
}
