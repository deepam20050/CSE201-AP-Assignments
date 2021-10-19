package instructor;

import java.util.ArrayList;
import java.util.Scanner;

import commontasks.CommonTasks;
import student.Student;
import assess.*;

public class Instructor implements CommonTasks  {
  private String name;
  private Scanner cin;
  public Instructor (String _name, Scanner _cin) {
    name = _name;
    cin = _cin;
  }

  public String get_name () {
    return name;
  }
  public void close_assessment (Assessments all) {
    all.print_non_closed();
    System.out.print("Enter id of assignment to close: ");
    int id = cin.nextInt();
    all.close(id);
  }
  @Override
  public void print_menu () {
    System.out.print("1. Add class material\n2. Add assessments\n3. View lecture materials\n4. View assessments\n5. Grade assessments\n6. Close assessment\n7. View comments\n8. Add comments\n9. Logout\n");
  }
  public void welcome () {
    System.out.println("Welcome " + name);
  }
  public void grade_assessment (Assessments all, ArrayList < Student > x) {
    System.out.println("List of assessments");
    all.print();
    System.out.print("Enter ID of assessment to view submissions: ");
    int id = cin.nextInt();
    boolean flag = false;
    for (int i = 0; i < x.size(); ++i) {
      if (x.get(i).is_ungraded(id)) {
        System.out.println(i + ". " + x.get(i).get_name());
        flag = true;
      }
    }
    if (!flag) {
      System.out.println("No ungraded assessments");
      return;
    }
    int who = cin.nextInt();
    System.out.println("Submission: " + x.get(who).get_submission(id));
    System.out.println("-------------------------------");
    System.out.println("Max Marks: " + x.get(who).get_max_marks(id));
    System.out.print("Marks scored: ");
    int marks = cin.nextInt();
    x.get(who).update_marks(id, marks, name);
  }
}
