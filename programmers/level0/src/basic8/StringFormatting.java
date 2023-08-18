package basic8;

import java.math.BigDecimal;

public class StringFormatting {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("18446744073709551615");
        BigDecimal bigDecimal2 = new BigDecimal("305793246910280479981");

        String string = bigDecimal.add(bigDecimal2).toString();

    }
}
