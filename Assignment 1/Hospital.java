package hospital;

import vaccinequan.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import vaccine.*;

public class Hospital {
  public String name;
  private int pincode;
  public int id;
  private HashMap < Integer, ArrayList < VaccineQuan > > slots;
  Hospital (String _name, int _pincode) {
    name = _name;
    pincode = _pincode;
    // random number generator taken from https://stackoverflow.com/a/363692
    id = ThreadLocalRandom.current().nextInt(100000, 1000000);
    slots = new HashMap<>();
    System.out.println("Hospital Name: " + name + ", PinCode: " + pincode + ", Unique ID: " + id);
  }
  public void show_slots (int what) {
    int cnt = 0;
    for (Integer day : slots.keySet()) {
      for (VaccineQuan x : slots.get(day)) {
        if (x.quan > 0) {
          if (what == 1) {
            System.out.print(cnt + "-> ");
          }
          System.out.println("Day: " + day + " Vaccine: " + x.name + " Available Qty: " + x.quan);
          ++cnt;
        }
      }
    }
  }
  public VaccineQuan get_vacc (int slot) {
    int cnt = 0;
    VaccineQuan ans;
    for (Integer day : slots.keySet()) {
      for (VaccineQuan x : slots.get(day)) {
        if (x.quan > 0) {
          if (cnt == slot) {
            ans = x;
          }
          ++cnt;
        }
      }
    }
    return ans;
  }
  public void update_slots (int day, String vacc, int quan) {
    if (!slots.containsKey(day)) {
      slots.put(day, new ArrayList < VaccineQuan > ());
    }
    boolean ok = false;
    for (VaccineQuan x : slots.get(day)) {
      if (x.name.equals(vacc)) {
        ok = true;
        x.quan += quan;
      }
    }
    if (!ok) {
      slots.get(day).add(new VaccineQuan(day, vacc, quan));
    }
  }
}
