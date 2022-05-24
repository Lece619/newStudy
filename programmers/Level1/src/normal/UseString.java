package normal;

public class UseString {
class Solution {
    public boolean solution(String s) {
        if(!(s.length()==4||s.length()==6)){
            return false;
        }
        return s.replaceAll("[0-9]","").length() == 0;
    }
}
}
