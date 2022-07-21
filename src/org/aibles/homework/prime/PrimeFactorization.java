package org.aibles.homework.prime;

import java.util.LinkedList;

public class PrimeFactorization {
  private static final int EVEN_PRIME = 2;
  private static final int FIRST_ODD_PRIME = 3;
  private static final int REMAINDER_OF_DIVISIBILITY = 0;
  private static final int MIN_VALUE_OF_PRIME_FACTORIZATION = 1;

  public void solve(int num) {
    LinkedList<Integer> result = new LinkedList<>();
    while (num % EVEN_PRIME == REMAINDER_OF_DIVISIBILITY) {
      num /= EVEN_PRIME;
      result.add(EVEN_PRIME);
    }
    for (int i = FIRST_ODD_PRIME; i <= Math.sqrt(num); i += 2) {
      while (num % i == REMAINDER_OF_DIVISIBILITY) {
        num /= i;
        result.add(i);
      }
    }
    if (num > MIN_VALUE_OF_PRIME_FACTORIZATION) {
      result.add(num);
    }
    System.out.println(result);
  }
}
