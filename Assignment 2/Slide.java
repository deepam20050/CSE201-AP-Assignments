package slide;

import java.util.*;
import materials.Materials;

public class Slide implements Materials {
  private String topic;
  private int no_of_slides;
  private String author;
  private Date date;
  private ArrayList < String > content;
  
  public Slide (String _topic, int _no_of_slides, String _author, Date _date, ArrayList < String > _content) {
    topic = _topic;
    no_of_slides = _no_of_slides;
    author = _author;
    date = _date;
    content = _content;
  }

  public void print () {
    System.out.println("Title: " + topic);
    for (int i = 1; i <= no_of_slides; ++i) {
      System.out.println("Slide " + i + ": " + content.get(i - 1));
    }
    System.out.println("Number of slides: " + no_of_slides);
    System.out.println("Date of upload: " + date);
    System.out.println("Uploaded by: " + author);
  }
}
