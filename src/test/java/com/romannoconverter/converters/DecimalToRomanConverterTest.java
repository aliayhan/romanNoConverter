package com.romannoconverter.converters;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing {@link DecimalToRomanConverter}.
 * 
 * @author Ayhan Dardagan
 *
 */
public class DecimalToRomanConverterTest {

  /**
   * Testing several conversions with expected results.
   */
  @Test
  public void convertingValidDecimals() {

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(0), DecimalToRomanConverter.ROMAN_0);
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(1), "I");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(2), "II");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(3), "III");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(4), "IV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(5), "V");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(6), "VI");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(7), "VII");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(8), "VIII");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(9), "IX");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(10), "X");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(11), "XI");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(12), "XII");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(13), "XIII");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(14), "XIV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(15), "XV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(16), "XVI");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(17), "XVII");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(18), "XVIII");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(19), "XIX");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(20), "XX");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(40), "XL");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(50), "L");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(90), "XC");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(400), "CD");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(500), "D");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(900), "CM");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(4000), "M(V•M)");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(5000), "(V•M)");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(9000), "M(X•M)");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(444), "CDXLIV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(999), "CMXCIX");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(521), "DXXI");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(4444), "M(V•M)CDXLIV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(9999), "M(X•M)CMXCIX");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(5210), "(V•M)CCX");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(44444), "_(X•M)(L•M)_M(V•M)CDXLIV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(99999), "_(X•M)(C•M)_M(X•M)CMXCIX");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(52100), "(L•M)MMC");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(444444),
        "_(C•M)(D•M)__(X•M)(L•M)_M(V•M)CDXLIV");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(999999),
        "_(C•M)(M•M)__(X•M)(C•M)_M(X•M)CMXCIX");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(521000), "(D•M)(X•M)(X•M)M");

    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(4000000), "(M•M)(M•M)(M•M)(M•M)");
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(9000000),
        "(M•M)(M•M)(M•M)(M•M)(M•M)(M•M)(M•M)(M•M)(M•M)");
  }

  /**
   * Testing several conversions with invalid decimals.
   */
  @Test
  public void convertingInvalidDecimals() {
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(0), DecimalToRomanConverter.ROMAN_0);
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(-1), null);
    assertEquals(DecimalToRomanConverter.convertDecimalToRoman(-100000000), null);
  }
}
