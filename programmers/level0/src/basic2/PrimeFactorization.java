package basic2;

import java.util.ArrayList;

public class PrimeFactorization {

        public int[] solution(int n) {
            ArrayList<Integer> primes = new ArrayList<>();
            primes.add(2);
            for (int i = 2; i < n + 1; i++) {
                if(isPrime(i)){
                    primes.add(i);
                }
            }
            return primes.stream().filter(i-> n % i == 0).mapToInt(i -> i).toArray();
        }

        private boolean isPrime(int num) {
            for (int j = 2; j < Math.sqrt(num)+1; j++) {
                if(num % j == 0){
                    return false;
                }
            }
            return true;
        }

    public static void main(String[] args) {
        PrimeFactorization primeFactorization = new PrimeFactorization();
        primeFactorization.solution(50);
    }
}
