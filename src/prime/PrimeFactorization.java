package prime;

import java.util.LinkedList;

public class PrimeFactorization {
    public void solve(int num) {
        LinkedList<Integer> result = new LinkedList<>();
        while (num % 2 == 0) {
            num /= 2;
            result.add(2);
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                num /= i;
                result.add(i);
            }
        }
        if (num > 1) {
            result.add(num);
        }
        System.out.println(result);
    }
}
