package game;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import calc.Calculator;
import ex.IntStrEx;
import intq.IntegerQ;
import tile.*;
import player.*;
import toys.Toy;
import carpet.*;

public class Game {
  private Scanner cin;
  private final int H;
  private final String ordinal[] = {"first", "second", "third", "fourth", "fifth"};
  private Random rand;
  private Player me;
  private Calculator mycalc;
  private Carpet mycarpet;
  public Game () {
    cin = new Scanner(System.in);
    H = 5;
    rand = new Random();
    mycalc = new Calculator();
    me = new Player();
    mycarpet = new Carpet();
  }
  public void mywait () throws IOException {
    for (int i = 0; i < 1 && System.in.read() != 0; ++i);
  }
  public int int_or_str () throws IntStrEx {
    String x = cin.nextLine();
    int op = 0;
    if (x.equals("integer")) {
      op = 1;
    } else if (x.equals("string")) {
      op = 2;
    } else {
      throw new IntStrEx("Neither integer or string chosen! Try again");
    }
    return op;
  }
  public void judge (boolean ok, int l) {
    if (ok) {
      Toy prize = mycarpet.get(l);
      System.out.println("You won a " + prize.get_name() + " soft toy");
      me.add(prize);
    } else {
      System.out.println("Incorrect Answer\nYou did not win any soft toy");
    }
  }
  public void solve_odd (int l) {
    int op = 0;
    while (op == 0) {
      try {
        System.out.println("Question answer round. Integer or strings?");
        op = int_or_str();
      } catch (IntStrEx e) {
        System.out.println(e.getMessage());
      }
    }
    if (op == 1) {
      int op1 = mycalc.get_int();
      int op2 = 0;
      while (op2 == 0) {
        op2 = mycalc.get_int();
      }
      System.out.printf("Calculate the result of %d divided by %d\n", op1, op2);
      boolean done = true;
      int res = 0;
      while (done) {
        try {
          Scanner new_cin = new Scanner(System.in);
          res = new_cin.nextInt();
          new_cin.nextLine();
          done = false;
        } catch (InputMismatchException e) {
          System.out.println("Incorrect input given!\nTry again!\n");
        }
      }
      judge(mycalc.check_int(op1, op2, res), l);
    } else {
      String op1 = mycalc.get_str();
      String op2 = mycalc.get_str();
      System.out.println("Calculate the concatenation of strings " + op1 + " and "  + op2);
      String res = cin.nextLine();
      judge(mycalc.check_str(op1, op2, res), l);
    }
  }
  public void play () throws IOException {
    System.out.println("Hit enter to initialize the game");
    mywait();
    System.out.println("Game is ready");
    for (int i = 1; i <= H; ++i) {
      System.out.println("Hit enter for your " + ordinal[i - 1] + " hop");
      mywait();
      int pos = rand.nextInt(21) + 1;
      if (pos > 20) {
        System.out.println("You are too energetic and zoomed past all the tiles. Muddy Puddle Splash!");
      } else {
        System.out.println("You landed on tile " + pos);
        if (pos % 2 == 0) {
          judge(true, pos);
        } else {
          solve_odd(pos);
        }
      }
    }
    System.out.println("Game Over");
    me.print();
  }
}