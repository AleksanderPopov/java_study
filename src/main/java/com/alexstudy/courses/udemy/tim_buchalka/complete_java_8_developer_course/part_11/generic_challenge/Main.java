package com.alexstudy.courses.udemy.tim_buchalka.complete_java_8_developer_course.part_11.generic_challenge;

/**
 * Created by Alex on 10/13/2016.
 */

/**
 * Create a generic class to implement a league table for a sport.
 * The class should allow teams to be added to the list, and store
 * a list of teams that belong to the league.
 * <p>
 * Your class should have a method to print out the teams in order,
 * with the team at the top of the league printed first.
 * <p>
 * Only teams of the same type should be added to any particular
 * instance of the league class - the program should fail to compile
 * if an attempt is made to add an incompatible team.
 */

public class Main {
    public static void main(String[] args) {
        LeagueTable<SoccerTeam> soccerTeamLeagueTable = new LeagueTable<>();
        soccerTeamLeagueTable.addParticipant(new SoccerTeam("Shahtar", 10));
        soccerTeamLeagueTable.addParticipant(new SoccerTeam("Dinamo", 5));
        soccerTeamLeagueTable.addParticipant(new SoccerTeam("Chernomorec", 12));
        soccerTeamLeagueTable.printTable();

        System.out.println("============================");

        LeagueTable<BaseballTeam> baseballTeamLeagueTable = new LeagueTable<>();
        baseballTeamLeagueTable.addParticipant(new BaseballTeam("Shahtar", 10));
        baseballTeamLeagueTable.addParticipant(new BaseballTeam("Dinamo", 5));
        baseballTeamLeagueTable.addParticipant(new BaseballTeam("Chernomorec", 12));
        baseballTeamLeagueTable.printTable();
    }
}
