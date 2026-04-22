package edu.teamrocket.frank_brunos_boxing;

public class RegularRound implements Round {
    private final String roundScore;
    private byte redBoxerScore;
    private byte blueBoxerScore;

    RegularRound(String roundScore) {
        this.roundScore = roundScore.replaceAll("\\s+", "");
        this.parseBoxerRoundScore();
    }
   String getRoundScore() {
        return this.roundScore;
    }

    private void parseBoxerRoundScore(){
        String[] scores = getRoundScore().split("-", 2);
        this.redBoxerScore = Byte.parseByte(scores[0]);
        this.blueBoxerScore = Byte.parseByte(scores[1]);
    }

    @Override
    public byte getredBoxerScore() {
        return this.redBoxerScore;
    }

    @Override
    public byte getblueBoxerScore() {
        return this.blueBoxerScore;
    }

    @Override
    public String toString() {
        return this.getredBoxerScore() + " - " + this.getblueBoxerScore();
    }
}