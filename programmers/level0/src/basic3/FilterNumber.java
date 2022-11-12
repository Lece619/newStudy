package basic3;

public class FilterNumber {
    public int[] solution(String my_string) {

        int[] ints = my_string.chars().filter(Character::isDigit).mapToObj(i -> Integer.parseInt(String.valueOf((char) i))).mapToInt(i -> i).sorted().toArray();

        return ints;
    }

    public static void main(String[] args) {
        FilterNumber filterNumber = new FilterNumber();
        int[] hi12392s = filterNumber.solution("hi12392");
        for (int hi12392 : hi12392s) {
            System.out.println("hi12392 = " + hi12392);
        }
    }
}
