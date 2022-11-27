package test_level;

public class Test1 {

    public int solution(int low, int high, String[] img) {
        int answer = 0;
        int row = img.length;
        int col = img[0].length();

        for (int n = 3; n <= Math.min(row, col); n++) {

            for (int i = 0; i <= row - n; i++) {

                for (int j = 0; j <= col - n; j++) {
                    if (checkFind(i, j, n, img)) {
                        int k = findBlack(i, j, n, img);
                        answer += checkBlack(low, high, n, k);
                    }
                }

            }
        }

        return answer;
    }

    private int checkBlack(int low, int high, int n, int k) {

        double total = k * 100 / Math.pow(n - 2, 2);
        if (total >= low && total < high) {
            return 1;
        }
        return 0;
    }

    private int findBlack(int startRow, int startCol, int n, String[] img) {
        int cnt = 0;
        for (int i = startRow + 1; i < startRow + n - 1; i++) {
            for (int j = startCol + 1; j < startCol + n - 1; j++) {
                if (img[i].charAt(j) == '#') {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean checkFind(int startRow, int startCol, int n, String[] img) {

        for (int i = 0; i < n; i++) {
            if(img[startRow].charAt(startCol+i) == '.' || img[startRow + n - 1].charAt(startCol+i) =='.'){
                return false;
            }
            if (img[startRow + i].charAt(startCol) == '.' || img[startRow + i].charAt(startCol + n - 1) == '.') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        int low = 25;
        int high = 51;
        String[] img = {
                ".########......",
                ".####...#......",
                ".#.####.#.#####",
                ".#.#..#.#.#..##",
                ".#.##.#.#.#...#",
                ".#.####.#.#...#",
                ".#....###.#####",
                ".########......"};
        int solution = test1.solution(low, high, img);
        System.out.println("solution = " + solution);
    }
}
