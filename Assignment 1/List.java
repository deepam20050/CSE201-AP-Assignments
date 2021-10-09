package list;

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
  private int hospital_codes = 999999;
  private final Scanner cin;
  public List (Scanner input_method) {
    ppl = new HashMap<>();
    hosp = new HashMap<>();
    vac = new HashMap<>();
    pincode_hosp = new HashMap<>();
    vacc_hosp = new HashMap<>();
    cin = input_method;
  }
  public void add_citizen () {
    System.out.print("Citizen Name: ");
    String name = cin.next();
    System.out.print("Age: ");
    int age = cin.nextInt();
    System.out.print("Unique ID: ");
    long id = cin.nextLong();
    System.out.println("Citizen Name: " + name + ", Age: " + age + ", Unique ID: " + id);
    if (id < 0) {
      System.out.println("Invalid ID");
      return;
    }
    if (age < 18) {
      System.out.println("Only above 18 are allowed");
      return;
    }
    Citizen tmp = new Citizen(name, age, id); 
    ppl.put(tmp.id, tmp);
  }
  public void add_hospital () {
    System.out.print("Hospital Name: ");
    String name = cin.next();
    System.out.print("PinCode: ");
    int pincode = cin.nextInt();
    Hospital tmp = new Hospital(name, pincode, hospital_codes--);
    hosp.put(tmp.id, tmp);
    if (!pincode_hosp.containsKey(pincode)) {
      pincode_hosp.put(pincode, new ArrayList<>());
    }
    pincode_hosp.get(pincode).add(tmp.id);
  }
  public void add_vaccine () {
    System.out.print("Vaccine Name: ");
    String name = cin.next();
    System.out.print("Number of Doses: ");
    int doses = cin.nextInt();
    if (doses == 1) {
      vac.put(name, new Vaccine(name, doses, 0));
    } else {
      System.out.print("Gap between Doses: ");
      int gap = cin.nextInt();
      vac.put(name, new Vaccine(name, doses, gap));
    }
    if (!vacc_hosp.containsKey(name)) {
      vacc_hosp.put(name, new ArrayList<>());
    }
  }
  public void citizen_status () {
    System.out.print("Enter Patient ID: ");
    long id = cin.nextLong();
    ppl.get(id).print_vacc_details();
  }
  public void hosp_slots () {
    System.out.print("Enter Hospital Id: ");
    int id = cin.nextInt();
    hosp.get(id).show_slots(0);
  }
  public void show_vacc () {
    int i = 0;
    for (String name : vac.keySet()) {
      System.out.println((i++) + ". " + name);
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
  }
  public void show_hosp_by_pin (int pincode) {
    for (Integer id : pincode_hosp.get(pincode)) {
      System.out.println(id + " " + hosp.get(id).name);
    }
  }
  public void booking (long citizen_id) {
    System.out.print("Enter hospital id: ");
    int id = cin.nextInt();
    if (!hosp.get(id).is_present(ppl.get(citizen_id).vacc, ppl.get(citizen_id).due)) {
      System.out.println("No slots available");
      return;
    }
    hosp.get(id).show_slots(1);
    System.out.print("Choose Slot: ");
    int slot = cin.nextInt();
    VaccineQuan what = hosp.get(id).get_vacc(slot);
    boolean check = ppl.get(citizen_id).update(what.day, vac.get(what.name).total_doses, vac.get(what.name).gap, what.name);
    if (check) {
      hosp.get(id).update_slots(what.day, what.name, -1);
    }
  }
  public void by_pincode (long citizen_id) {
    System.out.print("Enter PinCode: ");
    int pincode = cin.nextInt();
    show_hosp_by_pin(pincode);
    booking(citizen_id);
  }
  public void show_hosp_by_vacc (String vacc_name) {
    for (Integer id : vacc_hosp.get(vacc_name)) {
      System.out.println(id + " " + hosp.get(id).name);
    }
  }
  public void by_vacc (long citizen_id) {
    System.out.print("Enter Vaccine name: ");
    String vacc_name = cin.next();
    show_hosp_by_vacc(vacc_name);
    booking(citizen_id);
  }
  public void book_slot () {
    System.out.print("Enter patient Unique ID: ");
    long id = cin.nextLong();
    System.out.print("1. Search by area\n2. Search by Vaccine\n3. Exit\nEnter option: ");
    int op = cin.nextInt();
    if (op == 3) {
      return;
    }
    if (op == 1) {
      by_pincode(id);
    } else {
      by_vacc(id);
    }
  }
}
