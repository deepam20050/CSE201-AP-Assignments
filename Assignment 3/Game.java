package game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import common.Common;
import dice.Dice;
import elevator.Elevator;
import emptyfloor.EmptyFloor;
import kingcobra.KingCobra;
import ladder.Ladder;
import normalsnake.NormalSnake;
import player.Player;

public class Game {
  private ArrayList < Common > levels;
  private Dice mydice;
  private Player p1;
  private final int cnt_floors;
  
  /*
    Bonus description:

    I've coded another functionality of the game where the user can enter the number of 
    floors which she wants the game to have. Then the user can enter the number of Normal Snake,
    King Cobra, Ladder and elevator floors she'd like the game to have and then respectively enter 
    the corresponding floor numbers.

    All Normal Snakes move player's position to floor 1 and reduce 2 points of player's score irrespective of normal snake's floor
    All King Cobras move player's position to floor 3 and reduce 4 points of player's score irrespective of king cobra's floor
    and similarly for Ladder and Elevator floors.

    An execution of this bonus code is commented out in Main.java
  */
  private Scanner cin;
  public Game (String player_name, int no_of_floors, Scanner _cin) {
    cnt_floors = no_of_floors;
    levels = new ArrayList < Common > (Collections.nCopies(no_of_floors + 1, new EmptyFloor()));
    mydice = new Dice(2);
    p1 = new Player(player_name);
    cin = _cin;
    System.out.println("Enter number of Normal Snake floors");
    int n = cin.nextInt();
    for (int i = 0; i < n; ++i) {
      System.out.print("Enter floor no = ");
      levels.set(cin.nextInt(), new NormalSnake());
    }
    System.out.println("Enter number of King Cobra floors");
    n = cin.nextInt();
    for (int i = 0; i < n; ++i) {
      System.out.print("Enter floor no = ");
      levels.set(cin.nextInt(), new KingCobra());
    }
    System.out.println("Enter number of Ladder floors");
    n = cin.nextInt();
    for (int i = 0; i < n; ++i) {
      System.out.print("Enter floor no = ");
      levels.set(cin.nextInt(), new Ladder());
    }
    System.out.println("Enter number of Elevator floors");
    n = cin.nextInt();
    for (int i = 0; i < n; ++i) {
      System.out.print("Enter floor no = ");
      levels.set(cin.nextInt(), new Elevator());
    }
  }

  public Game (String player_name) {
    cnt_floors = 13;
    levels = new ArrayList < Common > (Collections.nCopies(cnt_floors + 1, new EmptyFloor()));
    mydice = new Dice(2);
    p1 = new Player(player_name);
    levels.set(5, new NormalSnake());
    levels.set(11, new KingCobra());
    levels.set(8, new Ladder());
    levels.set(2, new Elevator());
  }
  public boolean check_floor (int x) {
    return x <= cnt_floors;
  }
  public void player_details () {
    System.out.println("Player position Floor-" + p1.get_floor());
    System.out.println(p1.get_name() + " has reached an " + p1.get_floor_name() + " Floor");
    System.out.println("Total points " + p1.get_points());
  }
  public void update_floor (int dice_val) {
    int nxt_floor = dice_val + p1.get_floor();
    if (!check_floor(nxt_floor)) {
      System.out.println("Player cannot move");
      return;
    }
    Common tmp_floor = null;
    while (tmp_floor == null) {
      p1.update(nxt_floor, levels.get(nxt_floor));
      player_details();
      tmp_floor = levels.get(nxt_floor);
      nxt_floor = tmp_floor.get_floor();
      if (!tmp_floor.is_empty()) {
        tmp_floor = null;
      }
    }
  }
  public void print_dice () {
    System.out.println("Hit enter to roll the dice");
  }
  public boolean is_quit () {
    return p1.get_floor() == cnt_floors;
  }
  public void play () throws IOException {
    System.out.println("The game setup is ready");
    print_dice();
    while (System.in.read() != 0) {
      mydice.roll();
      int x = mydice.getFaceValue();
      if (x == 2) {
        System.out.println("Game cannot start until you get 1");
        print_dice();
        continue;
      }
      update_floor(x);
      print_dice();
      while (System.in.read() != 0) {
        mydice.roll();
        int dice_val = mydice.getFaceValue();
        update_floor(dice_val);
        if (is_quit()) {
          System.out.println("Game over");
          System.out.println(p1.get_name() + " accumulated " + p1.get_points() + " points");
          System.exit(0);
        }
        print_dice();
      }
    }
  }
}
