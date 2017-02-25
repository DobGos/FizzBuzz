package com.hearuexperts.fizzbuzz.declarative;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * @author Dobromir Gospodinov
 * @date 23/02/17
 */
public class FizzBuzzStep2 {

  static IntPredicate divisibleBy3 = (int num) -> num % 3 == 0;
  static IntPredicate divisibleBy5 = (int num) -> num % 5 == 0;
  static IntPredicate divisibleBy3and5 = divisibleBy3.and(divisibleBy5);
  static IntPredicate contains3 = new ContainsDigitPredicate(3);

  public String process(int from, int to) {
    return IntStream
            .rangeClosed(from, to)
            .mapToObj(FizzBuzzStep2::applyTest)
            .collect(joining(" "));
  }

  private static String applyTest(int num) {
    if (contains3.test(num)) return "luck";
    if (divisibleBy3and5.test(num)) return "fizzbuzz";
    if (divisibleBy3.test(num)) return "fizz";
    if (divisibleBy5.test(num)) return "buzz";
    return String.valueOf(num);
  }

}