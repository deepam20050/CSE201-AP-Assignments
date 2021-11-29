package tile;
import toys.*;

public class Tile {
  private int level;
  private Toy reward;
  public Tile (int _level, Toy _reward) {
    level = _level;
    reward = _reward;
  }
  public int get_level () {
    return level;
  }
  public Toy get_reward () {
    return reward.clone();
  }
}
