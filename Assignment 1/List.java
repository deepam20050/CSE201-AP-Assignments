import java.util.*;
import hospital.*;
import citizen.*;
import vaccine.*;
import vaccinequan.*;

public class List {
  private HashMap < Long ,Citizen > ppl;
  private HashMap < Integer, Hospital > hosp;
  private HashMap < String, Vaccine > vac;
  private HashMap < Integer, ArrayList < Integer > > pincode_hosp;
  private HashMap < String, ArrayList < Integer > > vacc_hosp;
  List () {
    ppl = new HashMap<>();
    hosp = new HashMap<>();
    vac = new HashMap<>();
    pincode_hosp = new HashMap<>();
    vacc_hosp = new HashMap<>();
  }
  public void add_citizen () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Citizen Name: ");
    String name = cin.next();
    System.out.print("Age: ");
    int age = cin.nextInt();
    System.out.print("Unique ID: ");
    long id = cin.nextLong();
    if (id < 0) {
      System.out.println("Invalid ID");
      cin.close();
      return;
    }
    if (age < 18) {
      System.out.println("Only above 18 are allowed");
      cin.close();
      return;
    }
    Citizen tmp = new Citizen(name, age, id); 
    ppl.put(tmp.id, tmp);
    cin.close();
  }
  public void add_hospital () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Hospital Name: ");
    String name = cin.next();
    System.out.print("PinCode: ");
    int pincode = cin.nextInt();
    Hospital tmp = new Hospital(name, pincode);
    hosp.put(tmp.id, tmp);
    if (!pincode_hosp.containsKey(pincode)) {
      pincode_hosp.put(pincode, new ArrayList<>());
    }
    pincode_hosp.get(pincode).add(tmp.id);
    cin.close();
  }
  public void add_vaccine () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Vaccine Name: ");
    String name = cin.next();
    System.out.print("Number of Doses: ");
    int doses = cin.nextInt();
    System.out.print("Gap between Doses: ");
    int gap = cin.nextInt();
    vac.put(name, new Vaccine(name, doses, gap));
    if (!vacc_hosp.containsKey(name)) {
      vacc_hosp.put(name, new ArrayList<>());
    }
    cin.close();
  }
  public void citizen_status () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter Patient ID: ");
    long id = cin.nextLong();
    ppl.get(id).print_vacc_details();
    cin.close();
  }
  public void hosp_slots () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter Hospital Id: ");
    int id = cin.nextInt();
    hosp.get(id).show_slots(0);
    cin.close();
  }
  public void show_vacc () {
    int i = 0;
    for (String name : vac.keySet()) {
      System.out.println((i++) + name);
    }
  }
  public String get_ith_vaccine (int i) {
    String ans = "";
    int idx = 0;
    for (String name : vac.keySet()) {
      if (idx == i) {
        ans = name;
      }
      ++idx;
    }
    return ans;
  }
  public void create_slots () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter Hospital ID: ");
    int id = cin.nextInt();
    System.out.print("Enter number of Slots to be added: ");
    int num_slots = cin.nextInt();
    while (num_slots > 0) {
      System.out.print("Enter Day Number: ");
      int day = cin.nextInt();
      System.out.print("Enter Quantity: ");
      int quan = cin.nextInt();
      System.out.println("Select Vaccine");
      show_vacc();
      int i = cin.nextInt();
      String vacc = get_ith_vaccine(i);
      hosp.get(id).update_slots(day, vacc, quan);
      if (!vacc_hosp.get(vacc).contains(id)) {
        vacc_hosp.get(vacc).add(id);
      }
      System.out.println("Slot added by Hospital " + id + " for Day: " + day + " , Available Quantity: " + quan + " of Vaccine " + vacc);
      --num_slots;
    }
    cin.close();
  }
  public void show_hosp_by_pin (int pincode) {
    for (Integer id : pincode_hosp.get(pincode)) {
      System.out.println(id + " " + hosp.get(id).name);
    }
  }
  public void booking (long citizen_id) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter hospital id: ");
    int id = cin.nextInt();
    hosp.get(id).show_slots(1);
    System.out.print("Choose Slot: ");
    int slot = cin.nextInt();
    VaccineQuan what = hosp.get(id).get_vacc(slot);
    boolean check = ppl.get(citizen_id).update(what.day, vac.get(what.name).total_doses, vac.get(what.name).gap, what.name);
    if (check) {
      hosp.get(id).update_slots(what.day, what.name, -1);
    }
    cin.close();
  }
  public void by_pincode (long citizen_id) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter PinCode: ");
    int pincode = cin.nextInt();
    show_hosp_by_pin(pincode);
    booking(citizen_id);
    cin.close();
  }
  public void show_hosp_by_vacc (String vacc_name) {
    for (Integer id : vacc_hosp.get(vacc_name)) {
      System.out.println(id + " " + hosp.get(id).name);
    }
  }
  public void by_vacc (long citizen_id) {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter Vaccine name: ");
    String vacc_name = cin.next();
    show_hosp_by_vacc(vacc_name);
    booking(citizen_id);
    cin.close();
  }
  public void book_slot () {
    Scanner cin = new Scanner(System.in);
    System.out.print("Enter patient Unique ID: ");
    long id = cin.nextLong();
    System.out.print("1. Search by area\n2. Search by Vaccine\n3. Exit\nEnter option: ");
    int op = cin.nextInt();
    if (op == 3) {
      cin.close();
      return;
    }
    if (op == 1) {
      by_pincode(id);
    } else {
      by_vacc(id);
    }
    cin.close();
  }
}
