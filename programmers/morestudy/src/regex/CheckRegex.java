package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegex {

    public static void main(String[] args) {
        String re = "[\"DSE\"]{2,}";
        StringBuilder sb = new StringBuilder(); 
        sb.append(re);
        String str = "ASWASWAEAWASEDSEDSEDSEA";
        Pattern p = Pattern.compile(re);
        Matcher m = p.matcher(str);
        System.out.println("m.find() = " + m.find());
        System.out.println("Pattern.matches(re,str) = " + Pattern.matches(sb.toString(), str));
    }
}
