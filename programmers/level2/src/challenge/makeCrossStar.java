/*
https://school.programmers.co.kr/learn/courses/30/lessons/87377
        코딩테스트 연습
        위클리 챌린지
        교점에 별 만들기
*/

package challenge;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class makeCrossStar {

    Set<Star> makeSet;
    long maxX, minX, maxY, minY;

    public String[] solution(int[][] line) {
        makeSet = new HashSet<>();
        maxX = Long.MIN_VALUE;
        minX = Long.MAX_VALUE;
        maxY = Long.MIN_VALUE;
        minY = Long.MAX_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i+1; j < line.length; j++) {
                makeStar(line[i], line[j]);
            }
        }
        maxX -= minX;
        maxY -= minY;

        StringBuilder base = new StringBuilder();
        IntStream.range(0, (int) (maxX+1)).forEach((a)-> base.append('.'));

        StringBuilder[] sbArr = new StringBuilder[(int) (maxY+1)];
        for (int i = 0; i < sbArr.length; i++) {
            sbArr[i] = new StringBuilder();
            sbArr[i].append(base);
        }

        for (Star star : makeSet) {
            int x = (int) (star.x - minX);
            int y = (int) (star.y - minY);
            sbArr[y].replace(x,x+1,"*");
        }

        for (StringBuilder stringBuilder : sbArr) {
            System.out.println("stringBuilder = " + stringBuilder);
        }
        String[] answer = new String[(int) (maxY+1)];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = sbArr[answer.length-1-i].toString();
        }

        for (String s : answer) {
            System.out.println("s = " + s);
        }
        return answer;
    }

    private void makeStar(int[] line1, int[] line2) {
        long a = line1[0];
        long b = line1[1];
        long e = line1[2];
        long c = line2[0];
        long d = line2[1];
        long f = line2[2];
        long check = (a*d - b*c);
        long starX;
        long starY;
        if( check == 0){
            return;
        }
        else{
            if(((b * f) - (e * d)) % check != 0){
                return;
            }
            if(((e * c) - (a * f)) % check != 0){
                return;
            }
            starX = ((b * f) - (e * d)) / check;
            starY = ((e * c) - (a * f)) / check;
            checkMinMax(starX, starY);
            makeSet.add(new Star(starX, starY));
        }
    }

    private void checkMinMax(long starX, long starY) {
        if(starX > maxX){
            maxX = starX;
        }
        if(starX < minX){
            minX = starX;
        }
        if(starY > maxY){
            maxY = starY;
        }
        if(starY < minY){
            minY = starY;
        }
    }

    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        Star star = new Star(1, 2);
        Star star2 = new Star(1, 2);

        String a = "21312";
        StringBuilder b = new StringBuilder();
        b.append("sdfsdf");
        b.replace(1,1,"1");
        System.out.println("b = " + b);

        makeCrossStar makeCrossStar = new makeCrossStar();
        makeCrossStar.solution(line);
//
//        Set<Star> set = new HashSet<>();
//        set.add(star);
//        set.add(star2);
//        System.out.println("set = " + set);
//        System.out.println("star==star2 = " + (star.equals(star2)));

    }

}

class Star {

    long x;
    long y;

    public Star(long x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (x+" "+y).hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        return this.x == ((Star)obj).x && this.y == ((Star)obj).y;
    }

    @Override
    public String toString() {
        return "x : " + x + " y : " + y + "\n";
    }
}
