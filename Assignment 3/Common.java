package common;

public class Common {
  private int points;
  private boolean empty;
  private int floor;
  private String floor_name;

  public Common () {
    points = 0;
    empty = false;
    floor = -1;
    floor_name = null;
  }
  public boolean is_empty () {
    return empty;
  }
  public int get_points () {
    return points;
  } 
  public int get_floor () {
    return floor;
  }
  public String get_floor_name () {
    return floor_name;
  }
  protected void update_floor (int x) {
    this.floor = x;
  }
  protected void update_points (int x) {
    this.points = x;
  }
  protected void update_floor_name (String x) {
    this.floor_name = x;
  }
  protected void update_empty (boolean x) {
    this.empty = x;
  }
}