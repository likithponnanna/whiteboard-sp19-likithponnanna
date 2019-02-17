package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.Course;
import com.example.whiteboardsp19likithponnanna.model.Lesson;
import com.example.whiteboardsp19likithponnanna.model.Module;
import com.example.whiteboardsp19likithponnanna.model.Topic;
import com.example.whiteboardsp19likithponnanna.model.Widget;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ModuleService {

  private Widget startWidget  = new Widget((long)123, "HEADING", "1", "Doc obj model",
          "Heading Name","Paragraph text","Paragraph Name","UNORDERED","Nodes,Nodes1", "List Name",
          "https://picsum.photos/200", "Image Name", "Link Text",
          "https://en.wikipedia.org/wiki/Document_Object_Model","Link Name");
  private List<Widget> widgets = new ArrayList<>(Arrays.asList(startWidget));

  private Topic startTopic = new Topic((long) 123,"Topic Title", widgets);

  private List<Topic> topics = new ArrayList <>(Arrays.asList(startTopic));

  private Lesson startLesson  = new Lesson((long) 123, "Lesson Title", topics);

  private List<Lesson> lessons = new ArrayList <>(Arrays.asList(startLesson));

  private Module startModule = new Module((long)123, "Module List", lessons );

  private List<Module> modules = new ArrayList <>(Arrays.asList(startModule));


  @GetMapping("/api/course/{cid}/modules")
  public List<Module> findAllModules(@PathVariable("cid") Long id) {
    return modules;
  }

  @GetMapping("/api/modules/{mid}")
  public Module findModuleById(@PathVariable("mid") Long id) {
    for (int i = 0; i < modules.size(); i++) {
      if (id.equals(modules.get(i).getId())) {
        return modules.get(i);
      }
    }
    return null;
  }

  @PostMapping("/api/courses/{cid}/modules")
  public Module createModule(@PathVariable("cid") Long id, @RequestBody Module module) {
    modules.add(module);
    return module;
  }

  @DeleteMapping("/api/modules/{mid}")
  public void deleteModule(@PathVariable("mid") Long id) {
    for (int i = 0; i < modules.size(); i++) {
      if (modules.get(i).getId().equals(id)) {
        modules.remove(i);
      }
    }
  }

  @PutMapping("/api/modules/{mid}")
  public Module updateModule(@PathVariable("mid") Long id, @RequestBody Course course) {
    for (int i = 0; i <= modules.size(); i++) {
      if (modules.get(i).getId().equals(id)) {
        if (course.getTitle() != null) {
          modules.get(i).setTitle(course.getTitle());
        }
        /*if (course.getModules() != null) {
          modules.get(i).setLessons(course.getModules());
        }*/

        return modules.get(i);
      }
    }
    return null;
  }


}
