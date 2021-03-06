package webdev.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String title;
    private String ownedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date modified;
    @OneToMany(mappedBy="course")
    private List<Module> modules;


    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getOwnedBy() {
      return ownedBy;
    }

    public void setOwnedBy(String ownedBy) {
      this.ownedBy = ownedBy;
    }

    public Date getCreated() {
      return created;
    }

    public void setCreated() {
      this.created = new Date();
    }

    public Date getModified() {
      return modified;
    }

    public void setModified() {
      this.modified = new Date();
    }

    public List<Module> getModules() {
      return modules;
    }

    public void setModules(List<Module> modules) {
      this.modules = modules;
    }
}

