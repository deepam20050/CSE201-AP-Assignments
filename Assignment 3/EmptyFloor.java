package emptyfloor;
import common.Common;

public class EmptyFloor extends Common {
  public EmptyFloor () {
    super();
    this.update_empty(true);
    this.update_floor(1);
    this.update_floor_name("Empty");
    this.update_points(1);
  }
}
