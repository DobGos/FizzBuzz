package com.hearuexperts.fizzbuzz.declarative;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Dobromir Gospodinov
 * @date 23/02/17
 */
public class FizzBuzzStep1Test {
  @Test
  public void from1To20ShouldProduceTheSpecifiedString(){
    // Given
    String expected = "1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 fizzbuzz 16 17 fizz 19 buzz";
    FizzBuzzStep1 fizzbuzz = new FizzBuzzStep1();

    // When
    String result = fizzbuzz.process(1, 20);

    // Then
    assertEquals(result, expected);
  }
}
