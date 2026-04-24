public class Player {
    private String name;
    private String team;
    private String position;
    private double ppg;
    private double rpg;
    private double apg;
    private double fgPct;

    public Player(String line) {
        String[] parts = line.split(";");

        try {
            this.name = parts[1];
            this.position = parts[2];
            this.team = parts[4];

            this.ppg = parseDoubleSafe(parts[29]); // PTS
            this.rpg = parseDoubleSafe(parts[23]); // TRB
            this.apg = parseDoubleSafe(parts[24]); // AST
            this.fgPct = parseDoubleSafe(parts[10]); // FG%
        } catch (Exception e) {
            System.out.println("Error parsing player: " + line);
        }
    }

    private double parseDoubleSafe(String value) {
        if (value == null || value.isEmpty()) return 0;
        return Double.parseDouble(value);
    }

    public String getName() { return name; }
    public String getTeam() { return team; }
    public String getPosition() { return position; }

    public double getStat(String stat) {
        switch (stat.toLowerCase()) {
            case "ppg": return ppg;
            case "rpg": return rpg;
            case "apg": return apg;
            case "fgpct": return fgPct;
            default: throw new IllegalArgumentException("Invalid stat: " + stat);
        }
    }

    @Override
    public String toString() {
        return name + " (" + team + ", " + position + ") | " +
               "PPG: " + ppg +
               " | RPG: " + rpg +
               " | APG: " + apg +
               " | FG%: " + fgPct;
    }
}
