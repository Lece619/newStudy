//https://www.acmicpc.net/problem/1655   가운데를 말해요


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n  = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < n; i++) {
            int nextNum = Integer.parseInt(br.readLine());

            arrayList.add(nextNum);
            stack.add(nextNum);
        }
        Collections.sort(arrayList);
        int idx = n / 2;
        if( n % 2 != 0){
            result = arrayList.get(idx)+("\n")+result;
            //sb.append(arrayList.get(idx)).append("\n");
            arrayList.remove(stack.pop());
        }
        idx--;
        while(!stack.isEmpty()){
            result = arrayList.get(idx)+("\n")+result;

//            sb.append(arrayList.get(idx)).append("\n");
            arrayList.remove(stack.pop());
            result = arrayList.get(idx)+("\n")+result;

//            sb.append(arrayList.get(idx)).append("\n");
            arrayList.remove(stack.pop());
            idx--;
        }
        System.out.println(result);
//        System.out.println(sb.toString());
    }
}
