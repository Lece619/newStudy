//https://www.acmicpc.net/problem/2559  백준 2559 - 수열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Num2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list =new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i-1] + Integer.parseInt(st.nextToken());

        }
        for (int i = K; i < nums.length; i++) {
            list.add(nums[i]-nums[i-K]);
        }
        System.out.println(Collections.max(list));
        //1 2 3 4   5   6
        //1 3 6 10 15  21
        //    6 9  12  15
    }
}
