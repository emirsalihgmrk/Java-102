package FixtureCreation;

import java.util.*;

public class Teams {
    private final Random rand = new Random();
    private final List<String> teams;
    public Teams(List<String> teams){
        this.teams = teams;
    }
    public ArrayList<ArrayList<String>> createFixture() {
        if (teams.size() % 2 != 0){
            this.teams.add("BAY");
        }
        Collections.shuffle(teams);
        ArrayList<String> copyOfTeams = new ArrayList<>(teams);
        ArrayList<ArrayList<String>> weeks = new ArrayList<>();
        String randTeam = copyOfTeams.get(rand.nextInt(copyOfTeams.size()));
        copyOfTeams.remove(randTeam);
        while (weeks.size() < teams.size()-1){
            ArrayList<String> week = new ArrayList<>();
            week.add(randTeam+" vs "+copyOfTeams.get(0));
            for (int i = 0;i < (copyOfTeams.size()-1)/2;i++){
                week.add(copyOfTeams.get(i+1)+" vs "+copyOfTeams.get(copyOfTeams.size()-i-1));
            }
            weeks.add(week);
            Collections.rotate(copyOfTeams,1);
        }
        return weeks;
    }
    public void printFixture(){
        ArrayList<ArrayList<String>> league = createFixture();
        Collections.shuffle(league);
        int weekNum = 1;
        for (ArrayList<String> week : league) {
            Collections.shuffle(week);
            System.out.println("-------");
            System.out.println("Week " + weekNum++);
            System.out.println("-------");
            for (int j = 0; j < week.size(); j++) {
                String[] parts = week.get(j).split(" vs ");
                int randHome = rand.nextInt(2);
                if (randHome == 0 && !parts[1].equals("BAY") || parts[0].equals("BAY")) {
                    week.set(j, parts[1] + " vs " + parts[0]);
                }
                System.out.println(week.get(j));
            }
        }
        weekNum = teams.size();
        for (ArrayList<String> strings : league) {
            System.out.println("-------");
            System.out.println("Week " + weekNum++);
            System.out.println("-------");
            for (String match : strings) {
                String[] parts = match.split(" vs ");
                if (parts[1].equals("BAY"))System.out.println(parts[0] + " vs " + parts[1]);
                else System.out.println(parts[1] + " vs " + parts[0]);
            }
        }
    }
    public void addTeam(String team){
        this.teams.add(team);
    }
}
