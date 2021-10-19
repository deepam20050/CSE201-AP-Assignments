package assess;

import java.util.ArrayList;

import materials.Materials;
import materials2.Materials2;

public class Assessments {
  private ArrayList < Materials > work;
  private ArrayList < Materials2 > work2;

  public Assessments () {
    work = new ArrayList<>();
    work2 = new ArrayList<>();
  }

  public void add_assessment (Materials x, Materials2 x_) {
    work.add(x);
    work2.add(x_);
  }
  public void print () {
    for (int i = 0; i < work.size(); ++i) {
      System.out.print("ID: " + i + " ");
      work.get(i).print();
      System.out.println("----------------");
    }
  }
  public void print_non_closed () {
    System.out.println("List of Open Assignments:");
    for (int i = 0; i < work2.size(); ++i) {
      if (!work2.get(i).is_closed()) {
        System.out.print("ID: " + i + " ");
        work.get(i).print();
        System.out.println("----------------");
      }
    }
  }
  public void close (int id) {
    work2.get(id).set_closed();
  }
}
