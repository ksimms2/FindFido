package edu.cnm.deepdive.green_print.model.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "response", strict = false)
public class CCResponse {

  @Element(name = "result_grand_total")
  private Float grandTotal;

  public Float getGrandTotal() {
    return grandTotal;
  }

  public void setGrandTotal(Float grandTotal) {
    this.grandTotal = grandTotal;
  }
}
