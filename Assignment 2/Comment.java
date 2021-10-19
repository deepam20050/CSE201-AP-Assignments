package comment;

import java.util.Date;

import materials.Materials;

public class Comment implements Materials {
  private String comment;
  private String author;
  private Date date;

  public Comment (String _comment, String _author, Date _date) {
    comment = _comment;
    author = _author;
    date = _date;
  }

  public void print () {
    System.out.println(comment + " - " + author);
    System.out.println(date);
  }
}
