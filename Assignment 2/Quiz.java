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
  @Override
  public void print () {
    System.out.println("Question: " + question);
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
