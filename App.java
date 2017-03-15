import java.io.Console;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args){
    Console myConsole = System.console();

    CD music = new CD("Bob", "Music", 2004, 15);
    CD sounds = new CD("Fred", "Sounds", 2001, 12);
    CD noise = new CD("Greg", "Noise", 2008, 15);
    CD saxophone = new CD("Sam", "Saxophone", 2003, 8);

    List<CD> allCDs = new ArrayList<CD>();
    allCDs.add(music);
    allCDs.add(sounds);
    allCDs.add(noise);
    allCDs.add(saxophone);

    System.out.println("Welcome to our CD store!");

    boolean programRunning = true;
    while (programRunning){
      System.out.println("Would you like to view albums by: all, name, year, or price, or type 'exit' to exit?");
      String navigationChoice = myConsole.readLine();

      if (navigationChoice.equals("all")){
        for ( CD cd : allCDs ){
          cdInfo(cd);
        }
      } else if (navigationChoice.equals("name")) {
          System.out.println("Enter artist name: ");
          String userArtist = myConsole.readLine();
          for ( CD cd : allCDs ){
            if ( cd.mArtistName.equals(userArtist)){
              cdInfo(cd);
          }
        }
      } else if (navigationChoice.equals("year")) {
          System.out.println("Enter album year: ");
          int userYear = Integer.parseInt(myConsole.readLine());
          for ( CD cd : allCDs ){
            if ( cd.mReleaseYear == userYear){
              cdInfo(cd);
            }
          }
      } else if (navigationChoice.equals("price")) {
          System.out.println("Enter max album price: ");
          int maxUserPrice = Integer.parseInt(myConsole.readLine());
          for ( CD cd : allCDs ){
            if ( cd.mPrice <= (maxUserPrice)){
              cdInfo(cd);
            }
          }
      } else if (navigationChoice.equals("exit")) {
          programRunning = false;

      } else {
          System.out.println("You are an infidel. Enter one of the selections.");
      }
    }
  }
  public static void cdInfo(CD artistCd) {
    CD artistCD = artistCd;
    System.out.println("--------------");
    System.out.println(artistCD.mArtistName);
    System.out.println(artistCD.mAlbum);
    System.out.println(artistCD.mReleaseYear);
    System.out.println("$" + artistCD.mPrice);
    System.out.println("--------------");
  }
}
