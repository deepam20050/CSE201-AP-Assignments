package citizen;

public class Citizen {
  private String name;
  private int age;
  public long id;
  private String vacc_status;
  public String vacc;
  public int due;
  private int taken;
  private int required;
  private final String[] s = new String[3];
  
  public Citizen (String _name, int _age, long _id) {
    name = _name;
    age = _age;
    id = _id;
    vacc_status = "REGISTERED";
    vacc = "";
    due = 0;
    taken = 0;
    required = 0;
    s[0] = "REGISTERED";
    s[1] = "PARTIALLY VACCINATED";
    s[2] = "FULLY VACCINATED";
  }
  public void print_vacc_details () {
    System.out.println(vacc_status);
    if (!vacc_status.equals(s[0])) {
      System.out.println("Vaccine Given: " + vacc);
      System.out.println("Number of Doses given: " + taken);
      if (taken != required) {
        System.out.println("Next Dose due date: " + due);
      }
    }
  }

  public boolean update (int day, int req, int gap_btwn, String vacc_name) {
    if (vacc_status.equals(s[2])) {
      System.out.println("Citizen already FULLY VACCINATED");
      return false;
    }
    if (vacc_status.equals(s[1])) {
      if (!vacc.equals(vacc_name)) {
        System.out.println(vacc + " was administered first. User wants to administer " + vacc_name + "! Not allowed !");
        return false;
      }
      if (day < due) {
        System.out.println("Not in due date");
        return false;
      }
      ++taken;
      if (taken == required) {
        vacc_status = s[2];
        System.out.println(name + " vaccinated with " + vacc_name);
        return true;
      }
      due = day + gap_btwn;
      System.out.println(name + " vaccinated with " + vacc_name);
      return true;
    }
    ++taken;
    if (req == 1) {
      vacc_status = s[2];
      required = 1;
      vacc = vacc_name;
      System.out.println(name + " vaccinated with " + vacc_name);
      return true;
    }
    vacc_status = s[1];
    required = req;
    vacc = vacc_name;
    due = day + gap_btwn;
    System.out.println(name + " vaccinated with " + vacc_name);
    return true;
  }
}
