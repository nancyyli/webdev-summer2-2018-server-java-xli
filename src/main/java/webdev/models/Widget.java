package webdev.models;


import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

@Entity
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int sortOrder;
    private String text;
    private String className;
    private String style;
    private String width;
    private String height;
    private String widgetType;
    private int size;
    private String src;
    private String href;
    private String listItem;
    private ListType listType;

    @ManyToOne
    @JsonIgnore
    private Lesson lesson;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public int getSortOrder() {
      return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
      this.sortOrder = sortOrder;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getClassName() {
      return className;
    }

    public void setClassName(String className) {
      this.className = className;
    }

    public String getStyle() {
      return style;
    }

    public void setStyle(String style) {
      this.style = style;
    }

    public String getWidth() {
      return width;
    }

    public void setWidth(String width) {
      this.width = width;
    }

    public String getHeight() {
      return height;
    }

    public void setHeight(String height) {
      this.height = height;
    }

    public void setLesson(Lesson lesson) {
      this.lesson = lesson;
    }

  public String getWidgetType() {
    return widgetType;
  }

  public void setWidgetType(String widgetType) {
    this.widgetType = widgetType;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public String getListItem() {
    return listItem;
  }

  public void setListItem(String listItem) {
    this.listItem = listItem;
  }

  public ListType getListType() {
    return listType;
  }

  public void setListType(ListType listType) {
    this.listType = listType;
  }
}