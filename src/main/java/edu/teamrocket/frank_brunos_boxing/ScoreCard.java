package edu.teamrocket.frank_brunos_boxing;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class ScoreCard {
    private final String color;
    private String redCorner = "";
    private String blueCorner = "";
    private String[] judgeScoreCard;
    private Byte RedBoxerFinalScore = 0;
    private Byte BlueBoxerFinalScore = 0;

    private List<Round> rounds = new ArrayList<Round>();

    public ScoreCard(String color) {
        this.color = color;
    }

    public void setRCorner(String boxerName) {
        this.redCorner = boxerName;
    }

    public void setBCorner(String boxerName) {
        this.blueCorner = boxerName;
    }

    private void setJudgeScoreCard(String[] judgeScoreCard) {
        this.judgeScoreCard = judgeScoreCard;
    }

    public byte getNumRounds() {
        return (byte) this.rounds.size();
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(this.rounds);
    }

    public void addRound(Round round) {
        this.rounds.add(round);
    }

    public void loadJudgeScoreCard(String[] judgeScoreCard) {
        this.setJudgeScoreCard(judgeScoreCard);

        for (var roundScore : this.judgeScoreCard) {
            var round = Optional.ofNullable(RoundFactory.getRound(roundScore));
            round.ifPresent(this::addRound);
        }
    }

    

    @Override
    public String toString() {
        return """
                 \t\t\t  %s
                \t\t%s\t%s
                \t\t\t%s rounds
                %s
                \t   FINAL SCORE: %s - %S FINALSCORE"""
                .formatted(
                    this.color,
                    this.redCorner,
                    this.blueCorner,
                    this.getNumRounds(),
                    this.viewRounds(),
                    this.getRedBoxerFinalScore(),
                    this.getBlueBoxerFinalScore()
                );
    }

    public byte getRedBoxerFinalScore() {
        if (this.RedBoxerFinalScore == 0) {
            int redBoxerTotalScore = 0;
            for (Round round : this.rounds) {
                redBoxerTotalScore += round.redBoxerScore();
            }
            this.RedBoxerFinalScore = (byte) redBoxerTotalScore;
        }
        return this.RedBoxerFinalScore;
    }

    public byte getBlueBoxerFinalScore() {
        if (this.BlueBoxerFinalScore == 0) {
            int blueBoxerTotalScore = 0;
            for (Round round : this.rounds) {
                blueBoxerTotalScore += round.blueBoxerScore();
            }
            this.BlueBoxerFinalScore = (byte) blueBoxerTotalScore;
        }
        return this.BlueBoxerFinalScore;

    }

    private String viewRounds() {
        StringBuilder roundsView = new StringBuilder();
        roundsView.append("\tRound \t Score \t Round \t Score \t Round\n")
                .append("\tScore \t Total \t       \t Total \t Score");

        byte numRound = 1;
        byte redBoxerTotalScore = 0;
        byte blueBoxerTotalScore = 0;

        for(Round round : this.rounds) {
            roundsView.append("""
                \n\t%s\t %s\t  %s\t %s\t %s"""
                .formatted(
                    round.redBoxerScore(),
                    redBoxerTotalScore += round.redBoxerScore(),
                    numRound++,
                    blueBoxerTotalScore += round.blueBoxerScore(),
                    round.blueBoxerScore()
                ));
        }
        return roundsView.toString();
    }
}