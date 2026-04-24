import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Season season = new Season();
    System.out.println("=== NBA Player Analytics System ===");

    String file = "C:\\Users\\cmac7\\Downloads\\NBA_stats_data\\2022_2023_NBA_Player_Stats_Regular.csv";
    season.loadFromCSV(file);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View All Players");
            System.out.println("2. Rank Players");
            System.out.println("3. Filter Players");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (Player p : season.getPlayers()) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Enter stat (ppg, rpg, apg, fgpct): ");
                    String stat = sc.next();
                    AnalyticsEngine.rankPlayers(season.getPlayers(), stat, 10);
                    break;

                case 3:
                    System.out.print("Enter stat (ppg, rpg, apg, fgpct): ");
                    String fStat = sc.next();

                    System.out.print("Enter minimum value: ");
                    double value = sc.nextDouble();

                    ArrayList<Player> filtered =
                        AnalyticsEngine.filterPlayers(season.getPlayers(), fStat, value);

                    System.out.println("\nFiltered Players:");
                    for (Player p : filtered) {
                        System.out.println(p);
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
