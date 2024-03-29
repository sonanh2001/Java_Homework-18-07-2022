package org.aibles.homework.prime;

public class FiveDigitPrime {
  private static final int LIMIT_INTEGER = 100000;
  private static final int FIRST_ODD_NUMBER_OF_FIVE_DIGIT = 10001;
  private static final int REMAINDER_OF_DIVISIBILITY = 0;
  private static final int DIVISOR_TO_GET_UNITS_VALUE = 10;
  private static final int DEFAULT_SUM = 0;
  private static final boolean[] checkPrime = new boolean[LIMIT_INTEGER];

  private void eratosthenes() {
    for (int index = 0; index < LIMIT_INTEGER; index++) {
      checkPrime[index] = true;
    }
    checkPrime[0] = checkPrime[1] = false;
    for (int i = 2; i <= Math.sqrt(LIMIT_INTEGER); i++) {
      if (checkPrime[i]) {
        for (int j = i * i; j < LIMIT_INTEGER; j += i) {
          checkPrime[j] = false;
        }
      }
    }
  }

  private int calSumDigit(int num) {
    int result = DEFAULT_SUM;
    while (num != REMAINDER_OF_DIVISIBILITY) {
      result += num % DIVISOR_TO_GET_UNITS_VALUE;
      num /= DIVISOR_TO_GET_UNITS_VALUE;
    }
    return result;
  }

  public void solve(int givenNum) {
    eratosthenes();
    for (int num = FIRST_ODD_NUMBER_OF_FIVE_DIGIT; num < LIMIT_INTEGER; num += 2) {
      if (checkPrime[num]) {
        if (calSumDigit(num) == givenNum) {
          System.out.println(num);
        }
      }
    }
  }
}
