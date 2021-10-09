import java.util.*;
import list.List;

class Main {
  public static Scanner cin = new Scanner(System.in);
  public static List booking = new List(cin);
  public static void menu () {
    System.out.println("---------------------------------");
    System.out.print("1. Add Vaccine\n"
    + "2. Register Hospital\n"
    + "3. Register Citizen\n"
    + "4. Add Slot for Vaccination\n"
    + "5. Book Slot for Vaccination\n"
    + "6. List all slots for a hospital\n"
    + "7. Check Vaccination Status\n"
     + "8. Exit\n\n");
    System.out.println("---------------------------------");
  }
  public static void main (String args[]) {  
    int op;
    System.out.println("CoWin Portal initialized....");
    while (true) {
      menu();
      op = cin.nextInt();
      if (op == 8) break;
      if (op > 8 || op < 1) {
        System.out.println("Incorrect menu option chosen! Please choose again!");
        continue;
      }
      if (op == 1) {
        booking.add_vaccine();
      } else if (op == 2) {
        booking.add_hospital();
      } else if (op == 3) {
        booking.add_citizen();
      } else if (op == 4) {
        booking.create_slots();
      } else if (op == 5) {
        booking.book_slot();
      } else if (op == 6) {
        booking.hosp_slots();
      } else if (op == 7) {
        booking.citizen_status();
      }
    }
  }
}