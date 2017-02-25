package com.hearuexperts.fizzbuzz.declarative;

import org.junit.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author Dobromir Gospodinov
 * @date 22/02/17
 */
public class FizzBuzzStep3Test {

  @Test
  public void from1To20ShouldProduceTheSpecifiedString(){
    // Given
    String expected = "1 2 luck 4 buzz fizz 7 8 fizz buzz 11 fizz luck 14 fizzbuzz 16 17 fizz 19 buzz";
    FizzBuzzStep3 fizzbuzz = new FizzBuzzStep3();
    int from = 1;
    int to = 20;

    // When
    FizzBuzzResult result = fizzbuzz.process(from, to);

    // Then
    assertEquals(result.getPrint().toString(), expected);
    assertEquals(result.getFizzCount(), 4);
    assertEquals(result.getBuzzCount(), 3);
    assertEquals(result.getFizzBuzzCount(), 1);
    assertEquals(result.getLuckCount(), 2);
    assertEquals(result.getNumCount(), 10);
  }
}