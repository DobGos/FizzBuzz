package com.hearuexperts.fizzbuzz.declarative;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Dobromir Gospodinov
 * @date 22/02/17
 */
public class FizzBuzzStep2Test {

  @Test
  public void from1To20ShouldProduceTheSpecifiedString(){
    // Given
    String expected = "1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz";
    FizzBuzzStep2 fizzbuzz = new FizzBuzzStep2();

    // When
    String result = fizzbuzz.process(1, 20);

    // Then
    assertEquals(result, expected);
  }

}
