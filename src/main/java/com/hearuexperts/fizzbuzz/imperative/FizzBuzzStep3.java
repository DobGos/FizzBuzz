package com.hearuexperts.fizzbuzz.imperative;

/**
 * @author Dobromir Gospodinov
 * @date 22/02/17
 */
public class FizzBuzzStep3 {

  int fizzCount;
  int buzzCount;
  int fizzBuzzCount;
  int luckCount;
  int numCount;

  public String process(int from, int to) {
    fizzCount = buzzCount = luckCount = numCount = 0;
    StringBuilder result = new StringBuilder();
    int watermark = result.length();
    for (int i = from; i <= to; i++) {

      if (Integer.toString(i).contains("3")) {
        result.append("luck");
        luckCount++;
      } else {
        if (i % 3 == 0 && i % 5 == 0) {
          result.append("fizzbuzz");
          fizzBuzzCount++;
        } else {
          if (i % 3 == 0) {
            result.append("fizz");
            fizzCount++;
          }
          if (i % 5 == 0) {
            result.append("buzz");
            buzzCount++;
          }
        }
      }

      if (result.length() == watermark) {
        result.append(i);
        numCount++;
      }

      result.append(' ');
      watermark = result.length();
    }

    return result.toString().trim();
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



  public static void main(String[] args) {
    FizzBuzzStep3 fizzBuzz = new FizzBuzzStep3();
    System.out.println(fizzBuzz.process(1, 20));
    System.out.println("fizz: " + fizzBuzz.getFizzCount());
    System.out.println("buzz: " + fizzBuzz.getBuzzCount());
    System.out.println("fizzbuzz: " + fizzBuzz.getFizzBuzzCount());
    System.out.println("luck: " + fizzBuzz.getLuckCount());
    System.out.println("number: " + fizzBuzz.getNumCount());

  }
}
