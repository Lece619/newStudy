package normal;

public class GcdLcm {
    public int[] solution(int n, int m) {

        int[] answer ={gbc(n,m),n*m/gbc(n,m)};
        return answer;
    }
    public int gbc(int a, int b){
        if(b==0){
            return a;
        }
        return gbc(b,a%b);
    }

    public static void main(String[] args) {
        int[][] a  = {{0,2,3,2},{23,21,3,4}};
        System.out.println(a[0].length);
    }
}
