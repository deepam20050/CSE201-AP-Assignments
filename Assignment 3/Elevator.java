package elevator;
import common.Common;

public class Elevator extends Common {
  public Elevator () {
    super();
    this.update_empty(false);
    this.update_floor(10);
    this.update_floor_name("Elevator");
    this.update_points(4);
  }
}
