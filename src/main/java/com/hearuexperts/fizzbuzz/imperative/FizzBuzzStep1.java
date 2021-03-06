package com.hearuexperts.fizzbuzz.imperative;

/**
 * @author Dobromir Gospodinov
 * @date 22/02/17
 */
public class FizzBuzzStep1 {


  public String process(int from, int to) {
    StringBuilder result = new StringBuilder();
    int watermark = result.length();
    for (int i = from; i <= to; i++) {
      if (i % 3 == 0) result.append("fizz");
      if (i % 5 == 0) result.append("buzz");

      if (result.length() == watermark)
        result.append(i);

      result.append(' ');
      watermark = result.length();
    }
    return result.toString().trim();
  }

  public static void main(String[] args) {
    System.out.println(new FizzBuzzStep1().process(1, 20));
  }
}
