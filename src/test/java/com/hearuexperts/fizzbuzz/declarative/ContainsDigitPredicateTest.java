package com.hearuexperts.fizzbuzz.declarative;

import org.junit.Test;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * @author Dobromir Gospodinov
 * @date 24/02/17
 */
public class ContainsDigitPredicateTest {

  @Test
  public void testAll(){
    // Given
    ContainsDigitPredicate cdp = new ContainsDigitPredicate(3);

    // When Then
    assertTrue(cdp.test(3));
    assertTrue(cdp.test(13));
    assertTrue(cdp.test(32));
    assertTrue(cdp.test(331));
    assertTrue(cdp.test(341));
    assertTrue(cdp.test(56341));

    assertFalse(cdp.test(1));
    assertFalse(cdp.test(21));
    assertFalse(cdp.test(421));

  }
}
