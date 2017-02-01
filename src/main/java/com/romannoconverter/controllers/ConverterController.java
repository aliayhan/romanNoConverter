package com.romannoconverter.controllers;

import static org.slf4j.LoggerFactory.getLogger;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.romannoconverter.converters.DecimalToRomanConverter;
import com.romannoconverter.forms.ConverterForm;

/**
 * Controller providing handlers for navigation and to execute roman to decimal convertions.
 * 
 * @author Ayhan Dardagan
 *
 */
@Controller
public class ConverterController {

  /**
   * Default logger.
   */
  private static final Logger LOG = getLogger(ConverterController.class);

  /**
   * Request to / leads to /converter.
   * 
   * @param converterForm
   *          Converter data form
   * @return Converter page
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String rootPage(final ConverterForm converterForm) {
    return "redirect:/converter";
  }

  /**
   * Request leads to converter page.
   * 
   * @param converterForm
   *          Converter data form
   * @return Converter page
   */
  @RequestMapping(value = "/converter", method = RequestMethod.GET)
  public String converterPage(final ConverterForm converterForm) {
    return "converter";
  }

  /**
   * Decimal to roman number conversion.
   * 
   * @param session
   *          Current HTTP session to store user name in
   * @param converterForm
   *          Converter data form
   * @param bindingResult
   *          Result of converter data form inputs (e.g. validation error)
   * @return Converter page
   */
  @RequestMapping(value = "/converter", method = RequestMethod.POST)
  public String doConversion(final HttpSession session, @Valid final ConverterForm converterForm,
      final BindingResult bindingResult) {

    int decimalNumber;

    // Init
    converterForm.setShowUnsuccessfulMsg(false);
    converterForm.setRomanNumber("");

    // Check for any input errors
    LOG.debug("Start conversion.");
    if (bindingResult.hasErrors()) {

      LOG.debug("User input has errors.");
      return "converter :: formFragment";
    }

    // Try to convert input to int
    try {
      decimalNumber = Integer.parseInt(converterForm.getDecimalNumber());
    } catch (NumberFormatException exception) {

      LOG.error("User input caused exception.", exception);
      // Show error message above the input fields -> NaN provided
      converterForm.setShowUnsuccessfulMsg(true);
      return "converter :: formFragment";
    }

    // Do conversion
    converterForm.setRomanNumber(DecimalToRomanConverter.convertDecimalToRoman(decimalNumber));

    return "converter :: formResultFragment";
  }
}
