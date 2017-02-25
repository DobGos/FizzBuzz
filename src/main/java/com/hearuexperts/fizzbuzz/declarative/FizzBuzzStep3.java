package com.hearuexperts.fizzbuzz.declarative;

import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * @author Dobromir Gospodinov
 * @date 23/02/17
 */
public class FizzBuzzStep3 {

  IntPredicate divisibleBy3 = (int num) -> num % 3 == 0;
  IntPredicate divisibleBy5 = (int num) -> num % 5 == 0;
  IntPredicate divisibleBy3and5 = divisibleBy3.and(divisibleBy5);
  IntPredicate contains3 = new ContainsDigitPredicate(3);
  IntFunction<String> numToStringMap =
          (int num) -> {
    if (contains3.test(num)) return "luck";
    if (divisibleBy3and5.test(num)) return "fizzbuzz";
    if (divisibleBy3.test(num)) return "fizz";
    if (divisibleBy5.test(num)) return "buzz";
    return String.valueOf(num);
  };

  public FizzBuzzResult process(int from, int to) {
    return IntStream
            .rangeClosed(from, to)
            .mapToObj(numToStringMap)
            .reduce(new FizzBuzzResult(), FizzBuzzResult::append, FizzBuzzResult::combine);
  }
}

class FizzBuzzResult {
  private int fizzCount;
  private int buzzCount;
  private int fizzBuzzCount;
  private int luckCount;
  private int numCount;
  private StringBuilder print = new StringBuilder();

  public FizzBuzzResult append(String string) {
    appendString(string);
    findAndIncrementCounter(string);
    return this;
  }

  private void appendString(CharSequence string) {
    if (this.print.length() > 0) this.print.append(' ');
    this.print.append(string);
  }

  private void findAndIncrementCounter(String string) {
    switch (string) {
      case "luck": luckCount++; break;
      case "fizz": fizzCount++; break;
      case "buzz": buzzCount++; break;
      case "fizzbuzz": fizzBuzzCount++; break;
      default: numCount++;
    }
  }

  public static FizzBuzzResult combine(FizzBuzzResult result1, FizzBuzzResult result2) {
    FizzBuzzResult combinedResult = new FizzBuzzResult();
    combinedResult.fizzCount = result1.fizzCount + result2.fizzCount;
    combinedResult.buzzCount = result1.buzzCount  + result2.buzzCount ;
    combinedResult.fizzBuzzCount = result1.fizzBuzzCount + result2.fizzBuzzCount;
    combinedResult.luckCount = result1.luckCount + result2.luckCount;
    combinedResult.numCount = result1.numCount + result2.numCount;
    combinedResult.appendString(result1.getPrint());
    combinedResult.appendString(result2.getPrint());
    return combinedResult;
  }

  public int getFizzCount() {
    return fizzCount;
  }

  public int getBuzzCount() {
    return buzzCount;
  }

  public int getFizzBuzzCount() {
    return fizzBuzzCount;
  }

  public int getLuckCount() {
    return luckCount;
  }

  public int getNumCount() {
    return numCount;
  }

  public String getPrint() {
    return print.toString();
  }
}