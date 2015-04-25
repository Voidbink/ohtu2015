package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

        Matcher m = new And(new HasFewerThan(13, "goals"),
                new PlaysIn("NYR"));

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
        System.out.println("----------------------------------------------");
        QueryBuilder query = new QueryBuilder();

        Matcher m1 = query.playsIn("NYR").hasFewerThan(51, "goals").hasAtLeast(1, "assists").build();

        for (Player player : stats.matches(m1)) {
            System.out.println(player);
        }

    }
}
