package normal;

public class IsSquar {
    public static void main(String[] args) {
        int n=16;
        double m = Math.sqrt((double)n);
        int newNum =((int)m*(int)m);
        System.out.println( (m-(int)m) == 0 );
    }

    public long solution(long n) {
        double m = Math.sqrt((double)n);
        return m-(int)m ==0 ? (int)(m+1)*(int)(m+1): -1;
    }
}
