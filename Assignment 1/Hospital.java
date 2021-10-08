package hospital;

import java.util.concurrent.ThreadLocalRandom;

public class Hospital {
  private String name;
  private int pincode;
  private int id;
  Hospital (String _name, int _pincode) {
    name = _name;
    pincode = _pincode;
    // random number generator taken from https://stackoverflow.com/a/363692
    id = ThreadLocalRandom.current().nextInt(100000, 1000000);
    System.out.println("Hospital Name: " + name + ", PinCode: " + pincode + ", Unique ID: " + id);
  }
}
