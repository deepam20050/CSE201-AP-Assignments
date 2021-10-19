package student;

import java.util.ArrayList;
import java.util.Scanner;

import assignment.Assignment;
import commontasks.CommonTasks;
import materials.Materials;
import materials2.Materials2;
import quiz.Quiz;

public class Student implements CommonTasks, Materials {
  private String name;
  private ArrayList < Integer > scores;
  private ArrayList < Materials > work;
  private ArrayList < String > submission;
  private ArrayList < Boolean > what;
  private ArrayList < Materials2 > work2;
  // 0 -> assignment
  // 1 -> quiz
  private ArrayList < String > by_who;
  private Scanner cin;

  public Student (String _name, Scanner _cin) {
    name = _name;
    scores = new ArrayList<>();
    work = new ArrayList<>();
    what = new ArrayList<>();
    by_who = new ArrayList<>();
    submission = new ArrayList<>();
    work2 = new ArrayList<>();
    cin = _cin;
  }
  public String get_name () {
    return name;
  }
  public void add_work (Materials x, Materials2 x_, boolean y) {
    work.add(x);
    what.add(y);
    scores.add(-1);
    by_who.add(null);
    submission.add(null);
    work2.add(x_);
  }
  public int get_max_marks (int idx) {
    return work2.get(idx).get_max_marks();
  }
  public String get_submission (int idx) {
    return submission.get(idx);
  }
  public boolean is_ungraded (int idx) {
    return submission.get(idx) != null && by_who.get(idx) == null;
  }
  public boolean check_zip (String s) {
    return s.length() >= 4 && s.substring(s.length() - 4).equals(".zip");
  }
  public void add_submission () {
    System.out.println("Pending assessments");
    boolean flag = false;
    for (int i = 0; i < work.size(); ++i) {
      if (work2.get(i).is_closed() || by_who.get(i) != null || submission.get(i) != null) continue;
      System.out.print("ID: " + i + " ");
      work.get(i).print();
      flag = true;
    }
    if (!flag) {
      System.out.println("No Pending assessments");
      return;
    }
    System.out.print("Enter ID of assessment: ");
    int id = cin.nextInt();
    cin.nextLine();
    if (!what.get(id)) {
      System.out.print("Enter filename of assignment: ");
      String ans = cin.nextLine();
      if (check_zip(ans)) {
        submission.set(id, ans);
      } else {
        System.out.println("Incorrect naming convention");
        return;
      }
    } else {
      System.out.print("Enter answer to Quiz question: ");
      String ans = cin.nextLine();
      submission.set(id, ans);
    }
    scores.set(id, 0);
  }
  public void update_marks (int idx, int marks, String instructor_name) {
    scores.set(idx, marks);
    by_who.set(idx, instructor_name);
  }
  @Override
  public void print_menu () {
    System.out.print("1. View lecture materials\n2. View assessments\n3. Submit assessment\n4. View grades\n5. View comments\n6. Add comments\n7. Logout\n");
  }
  public void welcome () {
    System.out.println("Welcome " + name);
  }
  @Override
  public void print () {
    System.out.println("Graded submissions");
    for (int i = 0; i < work.size(); ++i) {
      if (by_who.get(i) != null) {
        System.out.println("Submission : " + submission.get(i));
        System.out.println("Marks scored: " + scores.get(i));
        System.out.println("Graded by: " + by_who.get(i));
      }
    }
    System.out.println("----------------------------");
    System.out.println("Ungraded submissions");
    for (int i = 0; i < work.size(); ++i) {
      if (by_who.get(i) == null && submission.get(i) != null) {
        System.out.println("Submission : " + submission.get(i));
      }
    }
  }
}
