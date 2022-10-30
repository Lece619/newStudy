package basic3;

public class Combination {
    public int solution(int balls, int share) {
        return findCombination(balls, share);
    }

    private int findCombination(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return findCombination(n - 1, k) + findCombination(n - 1, k - 1);
    }
}
