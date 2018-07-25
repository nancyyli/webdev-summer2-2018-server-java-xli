package webdev.models;

import javax.persistence.*;


@Entity
@DiscriminatorValue("List")
public class List extends Widget{

  private String listItems;
  private ListType listType;


  public String getListItems() {
    return listItems;
  }

  public void setListItems(String listItems) {
    this.listItems = listItems;
  }

  public ListType getListType() {
    return listType;
  }

  public void setListType(ListType listType) {
    this.listType = listType;
  }
}