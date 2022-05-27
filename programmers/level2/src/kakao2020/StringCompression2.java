package kakao2020;

import java.util.LinkedList;
import java.util.Queue;

public class StringCompression2 {
    public int solution(String s) {

        int len = s.length()/2;
        int min =s.length();
        for (int k = 1; k <= len; k++) {

            Queue<String> queue = new LinkedList<>();
            String temp = "";
            int cnt = 1;

            for (int i = 0; i < s.length(); i += k) {
                if (i + k > s.length()) {
                    queue.add(s.substring(i));
                } else {
                    queue.add(s.substring(i, i + k));
                }
            }
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {
                String now = queue.poll();
                if(now.equals(queue.peek())){
                    cnt++;
                }else{
                    if(cnt!=1){
                        temp=temp+cnt+now;
                        cnt=1;
                    }else{
                        temp=temp+now;
                    }
                }
            }
            min=Math.min(temp.length(),min);
        }

        return min;
    }

    public static void main(String[] args) {

        new StringCompression2().solution("aaaa");
    }
}
