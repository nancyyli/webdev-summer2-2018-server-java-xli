package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


import webdev.models.Lesson;
import webdev.models.Widget;
import webdev.repositories.LessonRepository;
import webdev.repositories.WidgetRepository;

@CrossOrigin(origins = "*", maxAge=3600)
@RestController
public class WidgetService {
  @Autowired
  WidgetRepository repository;
  @Autowired
  LessonRepository lessonRepository;

  @GetMapping("/api/widget")
  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
  }

  @GetMapping("/api/widget/{widgetId}")
  public Widget findWidgetById(@PathVariable("widgetId") int widgetId) {
    Optional<Widget> data = repository.findById(widgetId);
    if(data.isPresent()) {
      return data.get();
    }
    return null;
  }

  @GetMapping("/api/lesson/{lessonId}/widget")
  public List<Widget> findAllWidgetsForLesson(@PathVariable("lessonId") int lessonId) {
    return repository.findWidgetsByLesson(lessonId);
  }

  @PostMapping("/api/lesson/{lessonId}/widget")
  public Widget createWidget(@PathVariable("lessonId") int lessonId, @RequestBody Widget widget) {
    Widget newWidget = new Widget();
    Optional<Lesson> lesson = lessonRepository.findById(lessonId);
    Optional<Widget> existWidget = repository.findById(widget.getId());
    if (lesson.isPresent()) {
      if (existWidget.isPresent()) {
        updateWidget(widget.getId(), widget);
      }
      else {
      newWidget.setClassName(widget.getClassName());
      newWidget.setLesson(lesson.get());
      newWidget.setName(widget.getName());
      newWidget.setSortOrder(widget.getSortOrder());
      newWidget.setWidgetType(widget.getWidgetType());
      newWidget.setText(widget.getText());
      switch (widget.getWidgetType()) {
        case "Heading":
          newWidget.setSize(widget.getSize());
          break;
        case "Link":
          newWidget.setHref(widget.getHref());
          break;
        case "Image":
          newWidget.setSrc(widget.getSrc());
          break;
        case "List":
          newWidget.setListItem(widget.getListItem());
          newWidget.setListType(widget.getListType());
          break;
        default:
          break;
        }
        repository.save(newWidget);
        return newWidget;
      }
    }
    return null;
  }

  @PutMapping("/api/widget/{widgetId}")
  public Widget updateWidget(@PathVariable("widgetId") int widgetId, @RequestBody Widget newWidget) {
    Optional<Widget> widget = repository.findById(widgetId);
    if(widget.isPresent()) {
      Widget widgetData = widget.get();
      widgetData.setText(newWidget.getText());
      widgetData.setSortOrder(newWidget.getSortOrder());
      widgetData.setName(newWidget.getName());
      widgetData.setClassName(newWidget.getClassName());

      if (widgetData.getWidgetType() != newWidget.getWidgetType()) {
          widgetData.setWidgetType(newWidget.getWidgetType());
          switch (newWidget.getWidgetType()) {
            case "Heading":
              widgetData.setSize(newWidget.getSize());
              break;
            case "Link":
              widgetData.setHref(newWidget.getHref());
              break;
            case "Image":
              widgetData.setSrc(newWidget.getSrc());
              break;
            case "List":
              widgetData.setListItem(newWidget.getListItem());
              widgetData.setListType(newWidget.getListType());
            default:
              break;
        }
      }
      repository.save(widgetData);
      return widgetData;
    }
    return null;
  }

  @DeleteMapping("/api/widget/{widgetId}")
  public void deleteWidget(@PathVariable("widgetId") int widgetId) {
    repository.deleteById(widgetId);
  }


}
