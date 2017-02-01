package com.romannoconverter.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.romannoconverter.forms.ConverterForm;

/**
 * Testing {@link ConverterController}.
 * 
 * @author Ayhan Dardagan
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(ConverterController.class)
public class ConverterControllerTest {

  /**
   * Spring MockMvc.
   */
  @Autowired
  private MockMvc mvc;

  /**
   * Request GET / path test.
   * 
   * @throws Exception
   *           Exception
   */
  @Test
  public void requestGetForRootPathTest() throws Exception {

    mvc.perform(get("/")).andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrl("/converter"));
  }

  /**
   * Request GET /converter path test.
   * 
   * @throws Exception
   *           Exception
   */
  @Test
  public void requestGetForConverterPathTest() throws Exception {

    mvc.perform(get("/converter")).andExpect(status().isOk()).andExpect(view().name("converter"));
  }

  /**
   * Request POST /converter path test, succesful conversion.
   * 
   * @throws Exception
   *           Exception
   */
  @Test
  public void requestPostForConverterPathSuccessTest() throws Exception {
    final String decimalNumber = "1234";

    ConverterForm converterForm = new ConverterForm();
    converterForm.setDecimalNumber(decimalNumber);
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formResultFragment"));
  }

  /**
   * Request POST /converter path test, invalid data test.
   * 
   * @throws Exception
   *           Exception
   */
  @Test
  public void requestPostForConverterPathInvalidDataTest() throws Exception {

    ConverterForm converterForm = new ConverterForm();
    converterForm.setDecimalNumber("");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Size"));

    converterForm.setDecimalNumber("1999999");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Size"));

    converterForm.setDecimalNumber("1,3");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Pattern"));

    converterForm.setDecimalNumber("1.3");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Pattern"));

    converterForm.setDecimalNumber("-10");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Pattern"));

    converterForm.setDecimalNumber("ABC");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Pattern"));

    converterForm.setDecimalNumber("134A0");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Pattern"));

    converterForm.setDecimalNumber("ÄÖ?ß§§$3^^3³");
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "Pattern"));

    converterForm.setDecimalNumber(null);
    mvc.perform(post("/converter").flashAttr("converterForm", converterForm))
        .andExpect(status().isOk()).andExpect(view().name("converter :: formFragment"))
        .andExpect(model().attributeHasFieldErrorCode("converterForm", "decimalNumber", "NotNull"));
  }
}
