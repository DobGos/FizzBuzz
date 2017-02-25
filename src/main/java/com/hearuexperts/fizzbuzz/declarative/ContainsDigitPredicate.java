package com.hearuexperts.fizzbuzz.declarative;

import java.util.function.IntPredicate;

/**
 * @author Dobromir Gospodinov
 * @date 24/02/17
 */
class ContainsDigitPredicate implements IntPredicate {

  int digit;

  public ContainsDigitPredicate(int digit) {
    this.digit = digit;
  }

  @Override
  public boolean test(final int number) {
    int n = number;
    while (n > 0) {
      int remainder = n % 10;
      if (remainder == digit) return true;
      n = n / 10;
    }
    return false;
  }
}
