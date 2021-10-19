package video;

import java.util.Date;
import materials.Materials;

public class Video implements Materials {
  private String topic;
  private String filename;
  private String author;
  private Date date;

  public Video (String _topic, String _filename, String _author, Date _date) {
    topic = _topic;
    filename = _filename;
    author = _author;
    date = _date;
  }

  public void print () {
    System.out.println("Title of video: " + topic);
    System.out.println("Video file: " + filename);
    System.out.println("Date of upload: " + date);
    System.out.println("Uploaded by: " + author);
  }
}
