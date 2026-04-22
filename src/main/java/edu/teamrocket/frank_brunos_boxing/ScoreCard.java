package edu.teamrocket.frank_brunos_boxing;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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

        for (String roundScore : this.judgeScoreCard) {
            if (roundScore != null) {
                this.addRound(new PointsDeducted(roundScore));
            }
        }
    }

    @Override
    public String toString() {
        return "\n\t\t\t   " + this.color
                + "\n\t\t" + this.blueCorner 
                + "\t" + this.redCorner 
                + "\n\t\t\t"
                + this.getNumRounds() + " rounds\n" 
                + this.viewRounds() 
                + "\n\t FINAL SCORE: "
                + this.getRedBoxerFinalScore() 
                + " - " 
                + this.getBlueBoxerFinalScore() 
                + " FINAL SCORE";       
    }

    public byte getRedBoxerFinalScore() {
        if (this.RedBoxerFinalScore == 0){
            int redBoxerTotalScore = 0;
            for (Round round : this.rounds) {
                redBoxerTotalScore += round.getRedBoxerScore();
        }
        this.RedBoxerFinalScore = (byte) redBoxerTotalScore;
        }
        return this.RedBoxerFinalScore;
    }

    public byte getBlueBoxerFinalScore() {
        if (this.BlueBoxerFinalScore == 0){
            int blueBoxerTotalScore = 0;
            for (Round round : this.rounds) {
                blueBoxerTotalScore += round.getBlueBoxerScore();
        }
        this.BlueBoxerFinalScore = (byte) blueBoxerTotalScore;
        }
        return this.BlueBoxerFinalScore;
        
    }

    private String viewRounds(){
        StringBuilder roundsView = new StringBuilder();
        roundsView.append("\tRound \t Score \t Round \t Score \t Round\n")
                  .append("\tScore \t Total \t       \t Total \t Score");

        byte numRound = 1;
        byte redBoxerTotalScore = 0;
        byte blueBoxerTotalScore = 0;

        for (Round round : this.rounds) {
            redBoxerTotalScore += round.getRedBoxerScore();
            blueBoxerTotalScore += round.getBlueBoxerScore();

            roundsView.append("\n\t")
                      .append(round.getRedBoxerScore())
                      .append("\t\s")
                      .append(redBoxerTotalScore += round.getRedBoxerScore())
                      .append("\t\s\s")
                      .append(numRound++)
                      .append("\t\s")
                      .append(blueBoxerTotalScore += round.getBlueBoxerScore())
                      .append("\t\s")
                      .append(round.getBlueBoxerScore());
        }
        return roundsView.toString();
    }
}