package vaccine;

public class Vaccine {
  private String name;
  private int total_doses;
  private int gap;
  Vaccine (String _name, int _total, int _gap) {
    name = _name;
    total_doses = _total;
    gap = _gap;
    System.out.println("Vaccine Name: " + name + ", Number of Doses: " + total_doses + ", Gap Between Doses: " + gap);
  }
}
