package commontasks;

import assess.*;
import lecmater.*;
import discuss.*;

public interface CommonTasks {
  default void view_material (LectureMaterial x) {
    x.print();
  }
  default void view_assessment (Assessments x) {
    x.print();
  }
  default void view_comment (Discuss x) {
    x.print();
  }
  default void add_comment (Discuss x, String author) {
    x.add_c(author);
  }
  public void print_menu ();
}
