package basic;

public class SaveArr {

    public String[] solution(String my_str, int n) {
        int size = (int) Math.ceil((double) my_str.length() / n);
        String[] answer = new String[size];
        int idx=-1;
        for (int i = 0; i < my_str.length(); i++) {
            if(i % n ==0){
                idx++;
                answer[idx] = my_str.charAt(i)+"";
            }else{
                answer[idx] += my_str.charAt(i);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SaveArr saveArr = new SaveArr();
        String[] a = saveArr.solution("abc1Addfggg4556b", 6);
        for (String s : a) {
            System.out.println("s = " + s);
        }

    }
}
