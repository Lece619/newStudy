package basic;

public class OXQuiz {
    public String[] solution(String[] quiz) {
        int size = quiz.length;
        String[] answer = new String[size];

        for (int i = 0; i < answer.length; i++) {
            String[] splitQ = quiz[i].split(" ");
            int X = Integer.parseInt(splitQ[0]);
            int Y = Integer.parseInt(splitQ[2]);
            int Z = Integer.parseInt(splitQ[4]);
            int cal = 0;

            if(splitQ[1].equals("-")){
                cal = X - Y;
            }else{
                cal = X + Y;
            }
            answer[i] = Z == cal ? "O" : "X";
        }

        for (int i = 0; i < answer.length; i++) {
            String[] split = quiz[i].split(" = ");
            StringBuilder num1 = new StringBuilder();
            for (int j = 0; j < split[0].length(); j++) {
                if(split[0].charAt(j)==' '){
                    break;
                }
                num1.append(split[0].charAt(j));
            }
            int first = Integer.parseInt(num1.toString());

        }

        return answer;
    }

    public static void main(String[] args) {
        OXQuiz oxQuiz = new OXQuiz();
        String[] quiz = {"-3 - 1 = 0", "5 + 6 = 11"};
        String[] solution = oxQuiz.solution(quiz);
        char a = 3;

        for (String s : solution) {
            System.out.println(s);
        }
    }
}
