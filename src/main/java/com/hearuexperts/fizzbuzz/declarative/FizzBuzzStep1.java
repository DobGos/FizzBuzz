package com.hearuexperts.fizzbuzz.declarative;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

/**
 * @author Dobromir Gospodinov
 * @date 23/02/17
 */
public class FizzBuzzStep1 {

  IntPredicate divisibleBy3 = (int num) -> num % 3 == 0;
  IntPredicate divisibleBy5 = (int num) -> num % 5 == 0;
  IntPredicate divisibleBy3and5 = divisibleBy3.and(divisibleBy5);

  public String process(int from, int to) {
    return IntStream
            .rangeClosed(from, to)
            .mapToObj(this::applyTest)
            .collect(joining(" "));
  }

  private String applyTest(int num) {
    if (divisibleBy3and5.test(num)) return "fizzbuzz";
    if (divisibleBy3.test(num)) return "fizz";
    if (divisibleBy5.test(num)) return "buzz";
    return String.valueOf(num);
  }
}