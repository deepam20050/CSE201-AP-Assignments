package toys;

public class Toy implements Cloneable {
  private String name;
  public Toy (String _name) {
    name = _name;
  }
  public String get_name () {
    return name;
  }
  @Override
  public Toy clone () {
    try {
      Toy x = (Toy)super.clone();
      return x;
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }
}
