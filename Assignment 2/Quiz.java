package quiz;

import materials.Materials;
import materials2.Materials2;

public class Quiz implements Materials, Materials2 {
  private String question;
  private boolean closed;
  private final int max_marks;

  public Quiz (String _question) {
    max_marks = 1;
    question = _question;
    closed = false;
  }

  public void print () {
    System.out.println("Question: " + question);
  }
  public int get_max_marks () {
    return max_marks;
  }
  public boolean is_closed () {
    return closed;
  }
  public void set_closed() {
    closed = true;
  }
}
