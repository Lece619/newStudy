package basic4;

public class CalPolynomial {
    public String solution(String polynomial) {
        String[] nums = polynomial.replaceAll("\\+ ", "").replaceAll("x","100").split(" ");
        int xNum = 0;
        int normalNum = 0;
        for (String num : nums) {
            int parseNum = Integer.parseInt(num);
            if(parseNum == 100){
                xNum ++ ;
                continue;
            }
            if(parseNum > 100){
                xNum += parseNum / 1000;
                continue;
            }
            normalNum += parseNum;
        }

        return makeAnswer(xNum, normalNum);
    }

    private String makeAnswer(int xNum, int normalNum) {
        if(xNum == 0){
            return String.valueOf(normalNum);
        }
        if(normalNum == 0)
            return oneX(xNum);
        return oneX(xNum) + " + " + normalNum;
    }

    private String oneX(int xNum) {
        if(xNum == 1){
            return "x";
        }
        return xNum + "x";
    }

    public static void main(String[] args) {

        CalPolynomial calPolynomial = new CalPolynomial();
        String solution = calPolynomial.solution("x + 12");
        System.out.println(solution);

    }
}
