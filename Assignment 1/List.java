import java.util.*;
import hospital.*;
import citizen.*;

public class List {
  private ArrayList < Citizen > ppl;
  private ArrayList < Hospital > hosp;
  List () {
    ppl = new ArrayList<>();
    hosp = new ArrayList<>();
  }
  public void add_citizen () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Citizen Name: ");
    String name = cin.next();
    System.out.print("Age: ");
    int age = cin.nextInt();
    System.out.print("Unique ID: ");
    long id = cin.nextLong();
    if (id < 0) {
      System.out.println("Invalid ID");
      cin.close();
      return;
    }
    if (age < 18) {
      System.out.println("Only above 18 are allowed");
      cin.close();
      return;
    }
    ppl.add(new Citizen(name, age, id));
    cin.close();
  }
  public void add_hospital () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Hospital Name: ");
    String name = cin.next();
    System.out.print("PinCode: ");
    int pincode = cin.nextInt();
    hosp.add(new Hospital(name, pincode));
    cin.close();
  }
}
