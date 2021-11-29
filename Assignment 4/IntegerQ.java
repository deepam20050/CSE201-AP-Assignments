package intq;
import question.*;

public class IntegerQ  {
  private Question < Integer > q;
  public IntegerQ (Integer _op1, Integer _op2) {
    q = new Question < Integer> (_op1, _op2);
    int res = _op1 / _op2;
    q.set_res(res);
  }
  public boolean check (Integer x) {
    return q.get_res() == x;
  }
}