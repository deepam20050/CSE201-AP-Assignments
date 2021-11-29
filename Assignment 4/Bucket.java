package bucket;

import java.util.ArrayList;
import toys.*;

public class Bucket {
  private ArrayList < Toy > won;
  public Bucket () {
    won = new ArrayList<>();
  }
  public void add_in_bucket (Toy x) {
    won.add(x);
  }
  public boolean isEmpty () {
    return won.isEmpty();
  }
  public void print () {
    for (Toy x : won) {
      System.out.print(x.get_name() + " ");
    }
    System.out.println();
  }
}