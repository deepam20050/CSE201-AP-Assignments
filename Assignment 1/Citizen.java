package citizen;

public class Citizen {
  private String name;
  private int age;
  private long id;
  private String vacc_status;
  private String vacc;
  private int due;
  private int taken;
  private int required;
  Citizen (String _name, int _age, long _id) {
    name = _name;
    age = _age;
    id = _id;
    vacc_status = "REGISTERED";
    vacc = "";
    due = 0;
    taken = 0;
    required = 0;
    System.out.println("Citizen Name: " + name + ", Age: " + age + ", Unique ID: " + id);
  }
  public void print_vacc_details () {
    System.out.println(vacc_status);
    if (!vacc_status.equals("REGISTERED")) {
      System.out.println("Vaccine Given: " + vacc);
      System.out.println("Number of Doses given: " + taken);
      if (taken != required) {
        System.out.println("Next Dose due date: " + due);
      }
    }
  }
}
