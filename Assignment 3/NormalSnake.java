package normalsnake;
import common.Common;

public class NormalSnake extends Common {
  public NormalSnake () {
    super();
    this.update_empty(false);
    this.update_floor(1);
    this.update_floor_name("Normal Snake");
    this.update_points(-2);
  }
}
