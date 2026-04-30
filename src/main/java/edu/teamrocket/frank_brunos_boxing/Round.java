package edu.teamrocket.frank_brunos_boxing;

sealed interface Round permits RegularRound, KnockdownRound, PointsDeducted {
    byte redBoxerScore();
    byte blueBoxerScore();
}