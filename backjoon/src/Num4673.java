public class Num4673 {
    public static int NextNum(int num){
        int result=num;
        while(true){
            result+=num%10;
            if(num<10) break;
            num/=10;
        }
//        String numString=""+num;
//        for (int i = 0; i < numString.length();i++){
//            result+=Integer.parseInt(String.valueOf(numString.charAt(i)));
//        }
        return result;
    }

    public static void main(String[] args) {
        int[] numList=new int[NextNum(9999)+1];

        for(int i=0;i<=10001;i++){
            numList[NextNum(i)]++;
        }
        for(int i=0;i<=10001;i++){
            if(numList[i]==0){
                System.out.println(i);
            }
        }
    }
}
