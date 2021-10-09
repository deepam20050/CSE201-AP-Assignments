package hospital;

import vaccinequan.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import vaccine.*;

public class Hospital {
  public String name;
  private int pincode;
  public int id;
  private HashMap < Integer, ArrayList < VaccineQuan > > slots;
  public Hospital (String _name, int _pincode, int _id) {
    name = _name;
    pincode = _pincode;
    id = _id;
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
  public void show_slots_vacc (String vacc_name) {
    int cnt = 0;
    for (Integer day : slots.keySet()) {
      for (VaccineQuan x : slots.get(day)) {
        if (x.quan > 0 && x.name.equals(vacc_name)) {
          System.out.println(cnt + "-> Day: " + day + " Vaccine: " + x.name + " Available Qty: " + x.quan);
          ++cnt;
        }
      }
    }
  }
  public VaccineQuan get_vacc_name (int slot, String vacc_name) {
    int cnt = 0;
    VaccineQuan ans = new VaccineQuan(0, null, 0);
    for (Integer day : slots.keySet()) {
      for (VaccineQuan x : slots.get(day)) {
        if (x.quan > 0 && vacc_name.equals(x.name) && cnt == slot) {
          ans = x;
        }
      }
    }
    return ans;
  }
  public VaccineQuan get_vacc (int slot) {
    int cnt = 0;
    VaccineQuan ans = new VaccineQuan(0, null, 0);
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
  public boolean is_present (String vacc_name, int due) {
    if (due == 0) return true;
    for (Integer day : slots.keySet()) {
      for (VaccineQuan x : slots.get(day)) {
        if (x.quan > 0) {
          if (vacc_name.equals(x.name) && due == day) return true;
        }
      }
    }
    return false;
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
