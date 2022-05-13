
import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Num5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Scanner sc = new Scanner(System.in);
        //int caseNum = sc.nextInt();
        int caseNum = Integer.parseInt(br.readLine());
        String lastResult="";
        for (int i = 0; i < caseNum; i++) {
//            String func = sc.next();
            String func = br.readLine();
            //int arSize = sc.nextInt();
            int arSize = Integer.parseInt(br.readLine());
            //br.readLine();
            //String arNum = sc.next().replaceAll("[\\[\\]]","");
            String arNum=br.readLine().replaceAll("[\\[\\]]","");
            //받은 수를 스트링 숫자 배열로
            String[] arrNum = arNum.split(",");
            Deque<String> deque =new ArrayDeque<>(Arrays.asList(arrNum));
            boolean checkReverse = false;
            String checkError=func.replace("R","");
            if(checkError.length()>arSize && !(checkError.length()==0)){
                //System.out.println("error");
                //lastResult+="error\n";
                bw.append("error\n");
                continue;
            }else if(arSize==0 && checkError.length()>0){
                bw.append("error\n");
                continue;
            }
            for (int j = 0; j < func.length(); j++) {
                if(func.charAt(j)=='R') {
                    checkReverse = !checkReverse;
                }else{
                    if(checkReverse){
                        deque.pollLast();
                    }else{
                        deque.pollFirst();
                    }
                }
            }
            if(deque.isEmpty()){
                //System.out.println("[]");
                //lastResult+="[]\n";
                bw.append("[]\n");
                continue;
            }
            String result ="[";
            bw.append('[');
            while(!deque.isEmpty()) {
                if(checkReverse){
                    bw.append(deque.pollLast());
                  //  result+=deque.pollLast()+",";
                }else{
                    //result+=deque.pollFirst()+",";
                    bw.append(deque.pollFirst());
                }
                if(deque.isEmpty()){
                    bw.append("]\n");
                }else{
                    bw.append(',');
                }
            }
            /*
            result = result.substring(0,result.length()-1) + "]";
            lastResult+=result+"\n";*/
        }
        //System.out.println(lastResult);
        bw.flush();
        bw.close();
        br.close();
    }
}
