package edu.cnm.deepdive.green_print.model.entity;

import javax.xml.bind.annotation.XmlElement;

public class CCResponse {

  @XmlElement(name = "result_grand_total")
  private Float grandTotal;

  public Float getGrandTotal() {
    return grandTotal;
  }

  public void setGrandTotal(Float grandTotal) {
    this.grandTotal = grandTotal;
  }
}
