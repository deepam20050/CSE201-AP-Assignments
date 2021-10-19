import java.util.Scanner;

import course.Course;

public class Main {
  public static Scanner cin = new Scanner(System.in);
  public static Course mycourse = new Course(cin);
  public static void backpack_menu () {
    System.out.println("Welcome to Backpack\n1. Enter as instructor\n2. Enter as student\n3. Exit");
  }
  public static void main(String[] args) {
    mycourse.add_instructor("I0");
    mycourse.add_instructor("I1");
    mycourse.add_student("S0");
    mycourse.add_student("S1");
    mycourse.add_student("S2");
    int op = -1;
    while (true) {
      backpack_menu();
      op = cin.nextInt();
      if (op == 3) {
        break;
      }
      if (op == 1) {
        mycourse.exec_instructor();
      } else {
        mycourse.exec_student();
      }
    }
  }
}
