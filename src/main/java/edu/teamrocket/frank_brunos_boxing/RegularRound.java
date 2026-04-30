package edu.teamrocket.frank_brunos_boxing;

record RegularRound(String roundScore, byte redBoxerScore, byte blueBoxerScore) implements Round {

    RegularRound {
        if (roundScore == null) throw new IllegalArgumentException("Round score cannot be null");
        
    }

    RegularRound(String roundScore){
        this (roundScore.replaceAll("\\s", ""),
        parseBoxerRoundScore(roundScore, Boxer.RED),
        parseBoxerRoundScore(roundScore, Boxer.BLUE)
    );
    }
    
   String getRoundScore() {
        return this.roundScore;
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