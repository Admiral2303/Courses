package com.gmail.vadimv41.statistic;

import java.util.ArrayList;

/**
 * Statistic class. Saves the history of the game
 */
public class Statistic {

    private int attemptsCount;
    private ArrayList<String> statistic;

    public Statistic() {
        this.attemptsCount = 0;
        this.statistic = new ArrayList<>();
    }

    public int getAttemptsCount() {
        return attemptsCount;
    }

    public void setAttemptsCount(int attemptsCount) {
        this.attemptsCount = attemptsCount;
    }

    public ArrayList<String> getStatistic() {
        return statistic;
    }

    public void setStatistic(ArrayList<String> statistic) {
        this.statistic = statistic;
    }

    /**
     * Add record to the statistic
     * @param record history record
     */
    public void addRecord(String record) {
        statistic.add(record);
    }

    /**
     * Increase attempts count
     */
    public void increaseAttemptsCount() {
        attemptsCount++;
    }
}
