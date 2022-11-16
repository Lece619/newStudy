package basic3;

public class MoveCoordination {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];

        int x = 0;
        int y = 0;

        int xRange = board[0] / 2;
        int yRange = board[1] / 2;

        for (String s : keyinput) {
            int newX = x + Move.valueOf(s).getX();
            int newY = y + Move.valueOf(s).getY();
            x = Math.min(newX, xRange);
            x = Math.max(x, -xRange);
            y = Math.min(newY, yRange);
            y = Math.max(y, -yRange);
        }

        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    static enum Move{
        up(0,1),
        down(0,-1),
        left(-1,0),
        right(1,0);

        private int x;
        private int y;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
