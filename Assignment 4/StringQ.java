package strq;
import question.*;

public class StringQ {
  private Question < String > q;
  public StringQ (String _op1, String _op2) {
    q = new Question < String > (_op1, _op2);
    String res = _op1 + _op2;
    q.set_res(res);
  }
  public boolean check (String x) {
    return q.get_res().equals(x);
  }
}