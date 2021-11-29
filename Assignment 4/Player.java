package player;

import bucket.Bucket;
import toys.Toy;

public class Player {
  private Bucket my_bucket;
  public Player () {
    my_bucket = new Bucket();
  }
  public void add (Toy x) {
    my_bucket.add_in_bucket(x);
  }
  public void print () {
    if (my_bucket.isEmpty()) {
      System.out.println("No soft toys won");
      return;
    }
    System.out.println("\nSoft toys won by you are:");
    my_bucket.print();
  }
}
