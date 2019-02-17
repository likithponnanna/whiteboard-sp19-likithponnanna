package com.example.whiteboardsp19likithponnanna.services;

import com.example.whiteboardsp19likithponnanna.model.Course;
import com.example.whiteboardsp19likithponnanna.model.Lesson;
import com.example.whiteboardsp19likithponnanna.model.Module;
import com.example.whiteboardsp19likithponnanna.model.Topic;
import com.example.whiteboardsp19likithponnanna.model.Widget;
import com.example.whiteboardsp19likithponnanna.services.UserService;

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
public class CourseService {

  private Widget startWidget  = new Widget((long)123, "HEADING", "1", "Doc obj model",
          "Heading Name","Paragraph text","Paragraph Name","UNORDERED","Nodes,Nodes1", "List Name",
          "https://picsum.photos/200", "Image Name", "Link Text",
          "https://en.wikipedia.org/wiki/Document_Object_Model","Link Name");
  private List<Widget> widgets = new ArrayList <>(Arrays.asList(startWidget));

  private Topic startTopic = new Topic((long) 123,"Topic Title", widgets);

  private List<Topic> topics = new ArrayList <>(Arrays.asList(startTopic));

  private Lesson startLesson  = new Lesson((long) 123, "Lesson Title", topics);

  private List<Lesson> lessons = new ArrayList <>(Arrays.asList(startLesson));

  private Module startModule = new Module((long)123, "Module List", lessons );

  private List<Module> modules = new ArrayList <>(Arrays.asList(startModule));

  private Course startCourse = new Course((long) 123,"Course Test 1", modules);
  private Course startCourse1 = new Course((long) 234,"Course Test 2", modules);

  private List<Course> courses = new ArrayList <>(Arrays.asList(startCourse,startCourse1));



  @GetMapping("/api/courses/{uid}")
  public List<Course> findAllCourses(@PathVariable("uid") Long id) {
    for (int i = 0; i < users ; i++) {

    }
    return courses;
  }

  @GetMapping("/api/courses/{cid}")
  public Course findCourseById(@PathVariable("cid") Long id) {
    for (int i = 0; i < courses.size(); i++) {
      if (id.equals(courses.get(i).getId())) {
        return courses.get(i);
      }
    }
    return null;
  }

  @PostMapping("/api/courses")
  public Course addCourse(@RequestBody Course course) {
    courses.add(course);
    return course;
  }

  @DeleteMapping("/api/courses/{cid}")
  public void deleteCourse(@PathVariable("cid") Long id) {
    for (int i = 0; i < courses.size(); i++) {
      if (courses.get(i).getId().equals(id)) {
        courses.remove(i);
      }
    }
  }

  @PutMapping("/api/courses/{cid}")
  public Course updateCourse(@PathVariable("cid") Long id, @RequestBody Course course) {
    for (int i = 0; i <= courses.size(); i++) {
      if (courses.get(i).getId().equals(id)) {
        if (course.getTitle() != null) {
          courses.get(i).setTitle(course.getTitle());
        }
        if (course.getModules() != null) {
          courses.get(i).setModules(course.getModules());
        }

        return courses.get(i);
      }
    }
    return null;
  }



  //private Course = new Course((long))


}
