package edu.teamrocket.frank_brunos_boxing;

record KnockdownRound(String roundScore, byte redBoxerScore, byte blueBoxerScore) implements Round {

    KnockdownRound {
        if (roundScore == null){
            throw new IllegalArgumentException("Round score cannot be null");
        }
    }

    KnockdownRound (String roundScore) {
        this (
            roundScore.replaceAll("\\s", ""),
            parseBoxerRoundScore(roundScore, Boxer.RED),
            parseBoxerRoundScore(roundScore, Boxer.BLUE)
        );
    }

    private static byte parseBoxerRoundScore(String roundScore, Boxer boxer) {
        String[] scores = roundScore.replaceAll("\\s", "").split("-", 2);
        return Byte.parseByte(scores[boxer.corner()]);
    }


    @Override
    public String toString() {
        return this.redBoxerScore() + " - " + this.blueBoxerScore();
    }
}