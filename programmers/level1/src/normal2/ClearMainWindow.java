package normal2;

public class ClearMainWindow {

    public int[] solution(String[] wallpaper) {

        int lux = wallpaper.length - 1;
        int luy = wallpaper[0].length() - 1;
        int rdx = 0;
        int rdy = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {

                char target = wallpaper[i].charAt(j);
                if (target == '#') {
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        ClearMainWindow clearMainWindow = new ClearMainWindow();
        String[] wallpaper = {".#...", "..#..", "...#."};
        int[] solution = clearMainWindow.solution(wallpaper);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }
}
