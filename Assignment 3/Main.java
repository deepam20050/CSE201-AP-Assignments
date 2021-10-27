import java.io.IOException;
import java.util.Scanner;

import game.Game;

class Main {
  public static Scanner cin = new Scanner(System.in);
  public static void main(String[] args) throws IOException {
    System.out.println("Enter the player name and hit enter");
    String name = cin.nextLine();
    Game gg = new Game(name);
    gg.play();

    /*
      Kindly uncomment lines 18-20 and comment 9-12 to execute the added
      functionality for the bonus part
    */
    // System.out.println("Enter number of floors you'd like the game to have");
    // int no_of_floors = cin.nextInt();
    // Game gg = new Game(name, no_of_floors, cin);
    // gg.play();
  }  
}
