public class Num4673 {
    //셀프넘버를 확인하는 함수 라기보단 한숫자의 다음 숫자를 확인
    public static int NextNum(int num){
        int result=num;
        while(true){
            //10으로 나누고 나머지계속 더하면 각자리수를 더한게 됨
            result+=num%10;
            //10보다 작을때 브레이크 만약 8이면
            //result+ = 8%10 =>8+8이되고 break !
            if(num<10) break;
            //10으로 나눈 나머지를 더한후에 num 을 10으로 나눔 다음 반복진행
            num/=10;
        }
        //스트링으로 한글자씩 받으려다 느릴것 같아서 취소 ( 파이썬형식)
//        String numString=""+num;
//        for (int i = 0; i < numString.length();i++){
//            result+=Integer.parseInt(String.valueOf(numString.charAt(i)));
//        }
        return result;
    }

    public static void main(String[] args) {
        //배열을 선언 index가 그 해당숫자가 셀프넘버가 있는지 확인하는것
        //0이면 한수 0이상이면 한수가 아님.
        //배열의 갯수는 10001숫자로 가장큰 한수가 나올 숫자까지 선언 9999 =>9999+9+9+9+9=NextNum[9999]
        int[] numList=new int[NextNum(9999)+1];
        //0부터 10001까지 NextNum에넣어서 다음숫자 확인 후 그 인덱스(숫자) +1
        for(int i=0;i<=10001;i++){
            numList[NextNum(i)]++;
        }
        //인덱스가 0이 아닌 것들의 인덱스만 출력 인덱스=해당숫자 
        for(int i=0;i<=10001;i++){
            if(numList[i]==0){
                System.out.println(i);
            }
        }
    }
}
