import java.util.*;

class Main {  
  public static void menu () {
    System.out.print("1. Add Vaccine\n"
    + "2. Register Hospital\n"
    + "3. Register Citizen\n"
    + "4. Add Slot for Vaccination\n"
    + "5. Book Slot for Vaccination\n"
    + "6. List all slots for a hospital\n"
    + "7. Check Vaccination Status\n"
     + "8. Exit\n");
  }
  public static void main (String args[]) {  
    Scanner cin = new Scanner(System.in);
    int op;
    while (true) {
      menu();
      op = cin.nextInt();
      if (op == 8) break;
    }
  }
}