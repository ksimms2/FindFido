package edu.cnm.deepdive.green_print.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Date;

 public class Consumption {

  @ColumnInfo(name = "consumption_id")
  @PrimaryKey(autoGenerate = true)
  private long id;

  @NonNull
 // @Expose
  private Date date;


  //@Expose
  private String category;

 // @Expose
  private String decription;

 // @Expose
  private String type;

 // @Expose
  private String url;

 // @Expose
  private Long amount;

  public long getId(){
    return id;
  }

  public void setId(long id) {
    this.id=id;
  }

  public Date getDate(){
    return date;
  }

  public void setDate(Date date){
    this.date=date;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount){
    this.amount = amount;
    }

  public String getCategory(){
    return category;
  }

  public void setCategory(String category){
    this.category=category;
  }

//  public String getDescription(){
//    return descritpion;
//  }
//
//  public void setDescription(String description){
//    this.description=description;
//  }
//
//  public String getCopyright(){
//    return copyright;
//  }
//
//  public void setCopyright(String copyright){
//    this.copyright=copyright;
//  }

  public String getUrl(){
    return url;
  }

  public void setUrl(String url){
    this.url=url;
  }


}
