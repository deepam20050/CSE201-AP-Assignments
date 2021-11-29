package carpet;

import tile.Tile;
import toys.Toy;

public class Carpet {
  private final String uniq_toys[] = {"Mickey Mouse", "Bugs Bunny", "Homer Simpson", "Goku", "Kitretsu", "Nobita", "Donald Duck", "Popeye", "Vegeta", "SpongeBob SquarePants", "Scooby", "Shaggy", "Velma", "Garfield", "Tom", "Jerry", "Pink Panther", "Road Runner", "Patrick", "Shrek", "Phineas", "Ferb", "Smurf", "Buzz Lightyear"};
  private Tile[] tiles = new Tile[21]; 
  public Carpet () {
    tiles[0] = null;
    for (int i = 1; i <= 20; ++i) {
      tiles[i] = new Tile(i, get_toy(i));
    }
  }
  public Toy get_toy (int l) {
    return new Toy(uniq_toys[l]);
  }
  public Toy get (int l) {
    return tiles[l].get_reward();
  }
}
