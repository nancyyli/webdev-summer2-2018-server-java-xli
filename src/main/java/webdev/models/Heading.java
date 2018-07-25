package webdev.models;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Heading")
public class Heading extends Widget{

  private int size;

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }
}