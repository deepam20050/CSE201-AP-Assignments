package calc;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import intq.IntegerQ;
import question.*;
import strq.StringQ;

public class Calculator {
  private final static String chars = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private final int N;
  private Random rand;
  public Calculator () {
    N = 4;
    rand = new Random();
  }
  public int get_int () {
    return ThreadLocalRandom.current().nextInt();
  }
  public String get_str () {
    StringBuilder ret = new StringBuilder(N);
    for (int i = 0; i < N; ++i) {
      int idx = rand.nextInt(chars.length());
      ret.append(chars.charAt(idx));
    }
    return ret.toString();
  }
  public boolean check_int (int a, int b, int c) {
    IntegerQ x = new IntegerQ(a, b);
    return x.check(c);
  }
  public boolean check_str (String a, String b, String c) {
    StringQ x = new StringQ(a, b);
    return x.check(c);
  }
}