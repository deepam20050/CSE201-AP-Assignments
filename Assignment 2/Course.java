package course;

import java.util.*;

import assignment.Assignment;
import discuss.Discuss;
import instructor.Instructor;
import lecmater.LectureMaterial;
import materials.Materials;
import materials2.Materials2;
import student.Student;
import slide.Slide;
import assess.*;
import video.*;
import quiz.*;

public class Course {
  private ArrayList < Instructor > profs;
  private ArrayList < Student > students;
  private Assessments all;
  private Discuss discuss;
  private LectureMaterial lmat;
  private Scanner cin;

  public Course (Scanner _cin) {
    profs = new ArrayList<>();
    students = new ArrayList<>();
    all = new Assessments();
    discuss = new Discuss(_cin);
    lmat = new LectureMaterial();
    cin = _cin;
  }

  public void add_instructor (String name) {
    profs.add(new Instructor(name, cin));
  }
  public void add_student (String name) {
    students.add(new Student(name, cin));
  }

  public boolean check_mp4 (String s) {
    return s.length() >= 4 && s.substring(s.length() - 4).equals(".mp4");
  }
  
  public void add_class_material (String author) {
    System.out.println("1. Add Lecture Slide\n2. Add Lecture Video");
    int op = cin.nextInt();
    if (op == 1) {
      System.out.print("Enter topic of slides: ");
      cin.nextLine();
      String topic = cin.nextLine();
      System.out.print("Enter number of slides: ");
      int no_of_slides = cin.nextInt();
      cin.nextLine();
      System.out.println("Enter content of slides");
      ArrayList < String > content = new ArrayList<>();
      for (int i = 0; i < no_of_slides; ++i) {
        System.out.printf("Content of slide %d: ", i + 1);
        content.add(cin.nextLine());
      }
      lmat.add_material(new Slide(topic, no_of_slides, author, new Date(), content));
      return;
    }
    System.out.print("Enter topic of video: ");
    cin.nextLine();
    String topic = cin.nextLine();
    System.out.print("Enter filename of video: ");
    String filename = cin.next();
    if (!check_mp4(filename)) {
      System.out.println("Incorrect naming convention");
      return;
    }
    lmat.add_material(new Video(topic, filename, author, new Date()));
  }
  public void add_assessment () {
    System.out.print("1. Add Assignment\n2. Add Quiz\n");
    int op = cin.nextInt();
    Materials x = null;
    Materials2 x_ = null;
    boolean y = false;
    cin.nextLine();
    if (op == 1) {
      System.out.print("Enter problem statement: ");
      String problem = cin.nextLine();
      System.out.print("Enter max marks: ");
      int max_marks = cin.nextInt();
      x = new Assignment(problem, max_marks);
      x_ = new Assignment(problem, max_marks);
      cin.nextLine();
    } else {
      System.out.print("Enter quiz question: ");
      String question = cin.nextLine();
      x = new Quiz(question);
      x_ = new Quiz(question);
      y = true;
    }
    all.add_assessment(x, x_);
    for (Student st : students) {
      st.add_work(x, x_, y);
    }
  }

  public void exec_instructor () {
    System.out.println("Instructors:");
    for (int i = 0; i < profs.size(); ++i) {
      System.out.println(i + " - " + profs.get(i).get_name());
    }
    System.out.println("Choose id: ");
    int id = cin.nextInt();
    String name = profs.get(id).get_name();
    int op = -1;
    profs.get(id).welcome();
    while (op != 9) {
      profs.get(id).print_menu();
      op = cin.nextInt();
      cin.nextLine();
      if (op == 1) {
        add_class_material(name);
      } else if (op == 2) {
        add_assessment();
      } else if (op == 3) {
        profs.get(id).view_material(lmat);
      } else if (op == 4) {
        profs.get(id).view_assessment(all);
      } else if (op == 5) {
        profs.get(id).grade_assessment(all, students);
      } else if (op == 6) {
        profs.get(id).close_assessment(all);
      } else if (op == 7) {
        profs.get(id).view_comment(discuss);
      } else if (op == 8) {
        profs.get(id).add_comment(discuss, name);
      } 
      profs.get(id).welcome();
    }
  }
  public void exec_student () {
    System.out.println("Students:");
    for (int i = 0; i < students.size(); ++i) {
      System.out.println(i + " - " + students.get(i).get_name());
    }
    System.out.println("Choose id: ");
    int id = cin.nextInt();
    int op = -1;
    String name = students.get(id).get_name();
    students.get(id).welcome();
    while (op != 7) {
      students.get(id).print_menu();
      op = cin.nextInt();
      cin.nextLine();
      if (op == 1) {
        students.get(id).view_material(lmat);
      } else if (op == 2) {
        students.get(id).view_assessment(all);
      } else if (op == 3) {
        students.get(id).add_submission();
      } else if (op == 4) {
        students.get(id).print();
      } else if (op == 5) {
        students.get(id).view_comment(discuss);
      } else if (op == 6) {
        students.get(id).add_comment(discuss, name);
      }
      students.get(id).welcome();
    }
  }
}
