package webdev.models;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Paragraph")
public class Paragraph extends Widget{

}