package edu.teamrocket.frank_brunos_boxing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KnockdownTest {
    
    @Test
    public void replaceTest() {
        KnockdownRound round = new KnockdownRound("10 - 8");
        assertEquals(round.roundScore(), "10-8");
    }

    @Test
    public void roundScoreToIntTest() {
        KnockdownRound round = new KnockdownRound("10 - 8");
        assertEquals(round.roundScore(), "10-8");
        assertEquals(10, round.redBoxerScore());
        assertEquals(8, round.blueBoxerScore());
    }
}