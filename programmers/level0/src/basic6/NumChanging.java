package basic6;

public class NumChanging {
    public int solution(int n, String control) {
        for (char c : control.toCharArray()) {
            n += KeyBoard.getValue(c);
        }
        return n;
    }

    enum KeyBoard{
        w(1),
        s(-1),
        d(10),
        a(-10);
        private int value;
        KeyBoard(int value){
            this.value = value;
        }
        public static int getValue(char key){
            switch(key){
                case 'w':
                    return w.value;
                case 's':
                    return s.value;
                case 'd':
                    return d.value;
                case 'a':
                    return a.value;
                default:
                    return 0;
            }
        }
    }
}
