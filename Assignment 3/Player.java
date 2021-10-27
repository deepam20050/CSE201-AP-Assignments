package player;
import common.Common;

public class Player extends Common {
  private String name;

  public Player (String _name) {
    super();
    this.update_empty(false);
    this.update_floor(-1);
    this.update_floor_name(null);
    this.update_points(0);
    this.name = _name;
  }
  public String get_name () {
    return this.name;
  }
  public void update (int nxt_floor, Common x) {
    super.update_floor(nxt_floor);
    super.update_points(super.get_points() + x.get_points());
    super.update_floor_name(x.get_floor_name());
  }
}
