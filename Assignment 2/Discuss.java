package discuss;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import comment.Comment;

public class Discuss {
  private ArrayList < Comment > comments;
  private Scanner cin;

  public Discuss (Scanner _cin) {
    comments = new ArrayList<>();
    cin = _cin;
  }

  public void add_c (String author) {
    System.out.print("Enter comment: ");
    comments.add(new Comment(cin.nextLine(), author, new Date()));
  }
  public void print () {
    for (Comment x : comments) {
      x.print();
      System.out.println();
    }
  }
}
