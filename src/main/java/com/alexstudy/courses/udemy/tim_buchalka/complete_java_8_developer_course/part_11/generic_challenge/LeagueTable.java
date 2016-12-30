package udemy.Tim_Buchalka.Complete_Java_8_Developer_Course.part_11.generic_challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by Alex on 10/13/2016.
 */

/**
 * ads
 * asd
 * as
 * d
 * asd
 * @param <T>
 */
public class LeagueTable<T extends Team> {
    private List<T> participants;

    public LeagueTable() {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(T participant) {
        participants.add(participant);
    }

    public void printTable() {
        Collections.sort(participants);
        Collections.reverse(participants);
        for (T participant : participants) {
            System.out.println(participant.toString());
        }
    }
}
