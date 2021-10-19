package lecmater;

import java.util.ArrayList;

import materials.Materials;

public class LectureMaterial {
  private ArrayList < Materials > mat;

  public LectureMaterial () {
    mat = new ArrayList<>();
  }

  public void add_material (Materials x) {
    mat.add(x);
  }
  public void print () {
    for (Materials x : mat) { 
      x.print();
      System.out.println("");
    }
  }
}
