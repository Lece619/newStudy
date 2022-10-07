package basic;

public class AlienLanguage {

    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for ( String word : dic ){
            String checkStr = word;
            boolean check = true;
            for ( String s : spell) {
                if(word.contains(s)){
                    checkStr = checkStr.replaceAll(s,"");
                }else{
                    check = false;
                }
            }
            if(checkStr.equals("") && check){
                answer = 1;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] spell = {"z", "d", "x"};
        String[] dic = {"def", "dww", "dzx", "loveaw"};
        AlienLanguage alienLanguage = new AlienLanguage();
        int solution = alienLanguage.solution(spell, dic);
        System.out.println("solution = " + solution);

    }
}
