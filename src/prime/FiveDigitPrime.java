package prime;

public class FiveDigitPrime {
    private static final int LIMIT_INTEGER = 100000;
    private static final int START_NUMBER_OF_FIVE_DIGIT = 10000;
    private static final boolean[] checkPrime = new boolean[LIMIT_INTEGER];

    private void eratosthenes() {
        for (int index = 0; index < LIMIT_INTEGER; index++) {
            checkPrime[index] = true;
        }
        checkPrime[0] = checkPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(LIMIT_INTEGER); i++) {
            if (checkPrime[i] == true) {
                for (int j = i * i; j < LIMIT_INTEGER; j += i) {
                    checkPrime[j] = false;
                }
            }
        }
    }

    private int calSumDigit(int num) {
        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return result;
    }

    public void solve(int givenNum) {
        eratosthenes();
        for (int num = START_NUMBER_OF_FIVE_DIGIT; num < LIMIT_INTEGER; num++) {
            if (checkPrime[num] == true) {
                if (calSumDigit(num) == givenNum) {
                    System.out.println(num);
                }
            }
        }
    }
}
