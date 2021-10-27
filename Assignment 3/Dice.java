package dice;

import java.util.Random;

public class Dice {
  private final int numFaces;
  private Random rand;
  private int faceValue;
  
  public Dice (int _numFaces) {
    numFaces = _numFaces;
    rand = new Random();
  }
  public void roll () {
    int curr_faceValue = 1 + rand.nextInt(numFaces);
    setFaceValue(curr_faceValue);
  }
  private void setFaceValue (int value) {
    faceValue = value;
  }
  public int getFaceValue () {
    System.out.println("Dice gave " + faceValue);
    return faceValue;
  }
}
