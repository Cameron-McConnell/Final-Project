import java.util.*;

public class AnalyticsEngine {

    public static void rankPlayers(ArrayList<Player> players, String stat, int topN) {
        players.sort((a, b) -> Double.compare(b.getStat(stat), a.getStat(stat)));

        System.out.println("\nTop " + topN + " Players by " + stat.toUpperCase());

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Player p = players.get(i);
            System.out.println((i + 1) + ". " + p.getName() +
                               " - " + p.getStat(stat));
        }
    }

    public static ArrayList<Player> filterPlayers(ArrayList<Player> players, String stat, double value) {
        ArrayList<Player> result = new ArrayList<>();

        for (Player p : players) {
            if (p.getStat(stat) > value) {
                result.add(p);
            }
        }

        return result;
    }
}
