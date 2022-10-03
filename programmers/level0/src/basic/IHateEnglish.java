package basic;

public class IHateEnglish {
    public long solution(String numbers) {
        String[] num = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < num.length; i++) {
            numbers = numbers.replaceAll(num[i],i+"");
        }
        return Long.parseLong(numbers.trim());
    }

    public static void main(String[] args) {
        IHateEnglish iHateEnglish = new IHateEnglish();
        long solution = iHateEnglish.solution("onetwothreefourfivesixseveneightnine");
        System.out.println("onetwothreefourfivesixseveneightnine = " + solution);
    }
}
