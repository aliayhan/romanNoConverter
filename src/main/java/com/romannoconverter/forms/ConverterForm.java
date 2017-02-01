package com.romannoconverter.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Form input data with validations.
 * 
 * @author Ayhan Dardagan
 * 
 */
public class ConverterForm {

  /**
   * Decimal number field - TODO: Put validation messages with appropriate keys to
   * messages.properties or Validations.properties.
   */
  @NotNull(message = "Please provide a valid number")
  @Pattern(regexp = "(\\d)*", message = "Please provide whole numbers")
  @Size(min = 1, max = 6, message = "Please provide a number between 0 to 999.999")
  private String decimalNumber;

  /**
   * Roman number field.
   */
  private String romanNumber;

  /**
   * Show unsuccessful message flag.
   */
  private boolean showUnsuccessfulMsg = false;

  // Getters / Setters

  /**
   * Gets decimal number.
   * 
   * @return Decimal number
   */
  public String getDecimalNumber() {
    return decimalNumber;
  }

  /**
   * Sets decimal number.
   * 
   * @param decimalNumber
   *          Decimal number
   */
  public void setDecimalNumber(String decimalNumber) {
    this.decimalNumber = decimalNumber;
  }

  /**
   * Gets roman number.
   * 
   * @return Roman number.
   */
  public String getRomanNumber() {
    return romanNumber;
  }

  /**
   * Sets roman number.
   * 
   * @param romanNumber
   *          Roman number.
   */
  public void setRomanNumber(String romanNumber) {
    this.romanNumber = romanNumber;
  }

  /**
   * Get show unsuccessul message flag.
   * 
   * @return Unsuccessul message flag
   */
  public boolean isShowUnsuccessfulMsg() {
    return showUnsuccessfulMsg;
  }

  /**
   * Set show unsuccessul message flag.
   * 
   * @param showUnsuccessfulMsg
   *          Unsuccessul message flag
   */
  public void setShowUnsuccessfulMsg(final boolean showUnsuccessfulMsg) {
    this.showUnsuccessfulMsg = showUnsuccessfulMsg;
  }
}