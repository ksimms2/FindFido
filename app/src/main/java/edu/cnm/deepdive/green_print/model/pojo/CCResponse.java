package edu.cnm.deepdive.green_print.model.pojo;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * <code>CCResponse</code> creates a container for results that are parsed
 * from {@link edu.cnm.deepdive.green_print.controller.CC_API} Element grandTotal is used to display
 * the score in {@link edu.cnm.deepdive.green_print.controller.ScoreFragment}
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

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

  @Element(name = "result_takeaction_grand_total")
  private Float takeActionGrandTotal;

  public Float getTakeActionGrandTotal() {
    return takeActionGrandTotal;
  }

  public void setTakeActionGrandTotal(Float takeActionGrandTotal) {
    this.takeActionGrandTotal = takeActionGrandTotal;
  }
}
