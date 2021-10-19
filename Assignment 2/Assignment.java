package assignment;

import materials.Materials;
import materials2.Materials2;

public class Assignment implements Materials, Materials2 {
  private String problem;
  private int max_marks;
  private boolean closed;

  public Assignment (String _problem, int _max_marks) {
    problem = _problem;
    max_marks = _max_marks;
    closed = false;
  }
  @Override
  public void print () {
    System.out.println("Assignment: " + problem + " Max Marks: " + max_marks);
  }
  @Override
  public int get_max_marks () {
    return max_marks;
  }
  @Override
  public boolean is_closed () {
    return closed;
  }
  @Override
  public void set_closed() {
    closed = true;
  }
}
