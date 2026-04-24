import java.io.*;
import java.util.*;

public class Season {
    private ArrayList<Player> players;

    public Season() {
        players = new ArrayList<>();
    }

    public void loadFromCSV(String filename) {
	    System.out.println("Attempting to load: " + filename); 
	    File f = new File(filename);
	    System.out.println("File exists: " + f.exists()); 
	    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                players.add(new Player(line));
            }

            System.out.println("Loaded " + players.size() + " players.");

        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        } 
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
