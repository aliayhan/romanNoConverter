package com.romannoconverter.converters;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.TreeMap;

import org.slf4j.Logger;

/**
 * This is class provides functions to convert decimal to roman numbers.
 * 
 * @author Ayhan Dardagan
 *
 */
public class DecimalToRomanConverter {

  public static final String ROMAN_0 = "[No sign for 0 in roman]";

  /**
   * Default logger.
   */
  private static final Logger LOG = getLogger(DecimalToRomanConverter.class);

  /**
   * Map tree hold keys in asc order of its keys.
   */
  private static final TreeMap<Integer, String> romanDecimalMap = new TreeMap<Integer, String>();

  static {
    romanDecimalMap.put(1, "I");
    romanDecimalMap.put(4, "IV");
    romanDecimalMap.put(5, "V");
    romanDecimalMap.put(9, "IX");
    romanDecimalMap.put(10, "X");
    romanDecimalMap.put(40, "XL");
    romanDecimalMap.put(50, "L");
    romanDecimalMap.put(90, "XC");
    romanDecimalMap.put(100, "C");
    romanDecimalMap.put(400, "CD");
    romanDecimalMap.put(500, "D");
    romanDecimalMap.put(900, "CM");
    romanDecimalMap.put(1000, "M");
    romanDecimalMap.put(4000, "M(V•M)");
    romanDecimalMap.put(5000, "(V•M)");
    romanDecimalMap.put(9000, "M(X•M)");
    romanDecimalMap.put(10000, "(X•M)");
    romanDecimalMap.put(40000, "_(X•M)(L•M)_");
    romanDecimalMap.put(50000, "(L•M)");
    romanDecimalMap.put(90000, "_(X•M)(C•M)_");
    romanDecimalMap.put(100000, "(C•M)");
    romanDecimalMap.put(400000, "_(C•M)(D•M)_");
    romanDecimalMap.put(500000, "(D•M)");
    romanDecimalMap.put(900000, "_(C•M)(M•M)_");
    romanDecimalMap.put(1000000, "(M•M)");
  }

  /**
   * Converts decimal to roman numbers
   * 
   * @param decimalNumber
   *          Decimal number
   * @return Roman number or null if decimalNumber < 0.
   */
  public static String convertDecimalToRoman(int decimalNumber) {

    if (decimalNumber < 0) {
      return null;
    } else if (decimalNumber == 0) {
      return ROMAN_0;
    }

    // Get key value which is the highest value "lower or equal" the given decimal
    int highestKeyvalue = romanDecimalMap.floorKey(decimalNumber);

    if (decimalNumber > highestKeyvalue) {
      return romanDecimalMap.get(highestKeyvalue)
          + convertDecimalToRoman(decimalNumber - highestKeyvalue);
    } else if (decimalNumber == highestKeyvalue) {
      return romanDecimalMap.get(highestKeyvalue);
    } else {
      LOG.error(
          "Conversion error: Bigger key found than decimal number. This should never happen.");
      return null;
    }
  }

}