package kakao2017;

import java.util.ArrayList;
import java.util.HashSet;

//https://programmers.co.kr/learn/courses/30/lessons/1835  단체사진 찍기
public class GroupPhoto {

    static public String[] m ;

    static ArrayList<String> list ;
    static ArrayList<String> totalList;
    static StringBuilder sb;
    static boolean visit[];
    public int solution(int n, String[] data) {
        //{A, C, F, J, M, N, R, T}
        int totalSize = 0;
        list = new ArrayList<>();
        totalList =new ArrayList<>();
        sb = new StringBuilder();
        m = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
        visit = new boolean[8];
        totalSize=makeSet(data);
        //System.out.println(totalList);
        return totalList.size();
    }
    public int makeSet(String[] data){
        if(sb.length()==m.length){
           // System.out.println(list.toString().replaceAll("[\\[\\], ]",""));
            boolean flag =true;
            String nowString=sb.toString();
            //System.out.println(nowString);
            for (String datum : data) {
                if(!check2(datum,nowString)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                totalList.add(nowString);
            }
            //System.out.println(list);
        }else{
            for (int i = 0; i < m.length; i++) {
//                if(!list.contains(m[i])){
//                    list.add(m[i]);
//                    makeSet(data);
//                    list.remove(m[i]);
//                }
                if(!visit[i]){
                    visit[i]=true;
                    sb.append(m[i]);
                    makeSet(data);
                    sb.deleteCharAt(sb.length()-1);
                    visit[i]=false;
                }
            }
        }
        return totalList.size();
    }
    public boolean check2(String command,String s){
        char[] commands = command.toCharArray();
        StringBuilder sb =new StringBuilder();
        boolean result = true;
        int standard = Integer.parseInt(commands[4]+"");
        switch(commands[3]){
            case '=' :
                    if(!(Math.abs(s.indexOf(commands[0])-s.indexOf(commands[2]))==standard+1)){
                        return false;
                }
                break;
            case '>' :
                    if(!(Math.abs(s.indexOf(commands[0])-s.indexOf(commands[2]))>standard+1)){
                        return false;
                    }

                break;
            case '<' :
                    if(!(Math.abs(s.indexOf(commands[0])-s.indexOf(commands[2]))<standard+1)){
                        return false;
                    }

                break;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] command = {"N~F=0", "R~T>2"};
        new GroupPhoto().solution(2,command);
        //System.out.println(totalList);
        System.out.println(totalList.size());
    }

}
