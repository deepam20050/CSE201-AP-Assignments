package question;

public class Question < T > {
  private T op1;
  private T op2;
  private T res;
  public Question (T _op1, T _op2) {
    op1 = _op1;
    op2 = _op2;
  }
  public void set_res (T _res) {
    res = _res;
  }
  public T get_res () {
    return res;
  }
}