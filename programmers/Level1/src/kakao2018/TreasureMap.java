package kakao2018;

public class TreasureMap {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(9));
        char a = '1';
        if(a=='1') System.out.println("true");
        String bi = "10100";

    }
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            binary1[i]=makeBinary(arr1[i],n);
            binary2[i]=makeBinary(arr2[i],n);
            answer[i]="";
            for (int j = 0; j < binary1.length; j++) {
                if(binary1[i].charAt(j)==binary2[i].charAt(j)&&
                        binary1[i].charAt(j)=='0'){
                    answer[i]+=" ";
                }else{
                    answer[i]+="#";
                }
            }
        }
        return answer;
    }
    public String makeBinary(int num,int n){
        String binary = Integer.toBinaryString(num);
        int zero = n-binary.length();
        for (int i = 0; i < zero; i++) {
            binary="0"+binary;
        }
        return binary;
    }
}
}
