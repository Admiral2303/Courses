package com.gmail.vadimv41.model;

import com.gmail.vadimv41.statistic.Statistic;

import java.util.Random;

/**
 * GameModel class
 */
public class GameModel {

    private int startNumber;
    private int endNumber;
    private Random randomizer;

    private int resultNumber;
    private int currentLeftBound;
    private int currentRightBound;
    private Statistic statistic;

    /**
     * Constructor
     * @param startNumber left bound of the game interval
     * @param endNumber right bound of the game interval
     */
    public GameModel(int startNumber, int endNumber) {
        this.startNumber = startNumber;
        this.endNumber = endNumber;
        this.randomizer = new Random();
        this.statistic = new Statistic();
        this.currentLeftBound = startNumber;
        this.currentRightBound = endNumber;
    }

    public void generateResultNumber() {
        resultNumber = randomizer.nextInt((endNumber - startNumber)) + startNumber + 1;
    }

    /**
     * Compares number with result
     * @param number number for comparison
     * @return result of comparison of the number with result
     */
    public int checkUserInput(int number) {
        statistic.increaseAttemptsCount();
        if (number == resultNumber) {
            winTheGame(number);
            return 0;
        } else if (number < resultNumber) {
            currentLeftBound = number;
            addRecordAboutLeftBound(number);
            return -1;
        } else {
            currentRightBound = number;
            addRecordAboutRightBound(number);
            return 1;
        }
    }

    /**
     * Add record to statistic about number which smaller then result
     * @param number number
     */
    private void addRecordAboutLeftBound(int number) {
        String record ="You enter: " + number + " This number is smaller then result.\n" +
                "Interval [" + currentLeftBound + "; " + currentRightBound + "]";
        statistic.addRecord(record);
    }

    /**
     * Add record to statistic about number which bigger then result
     * @param number number
     */
    private void addRecordAboutRightBound(int number) {
        String record = "You enter: " + number + " This number is bigger then result.\n" +
                "Interval [" + currentLeftBound + "; " + currentRightBound + "]";
        statistic.addRecord(record);
    }

    /**
     * Add record to statistic about winning
     * @param number number
     */
    private void winTheGame(int number) {
        String record = "You enter: " + number + " This number is correct.\n";
        statistic.addRecord(record);
    }


    public int getCurrentLeftBound() {
        return currentLeftBound;
    }

    public int getCurrentRightBound() {
        return currentRightBound;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public int getStartNumber() {
        return startNumber;
    }

    public void setStartNumber(int startNumber) {
        this.startNumber = startNumber;
    }

    public int getEndNumber() {
        return endNumber;
    }

    public void setEndNumber(int endNumber) {
        this.endNumber = endNumber;
    }

    public Random getRandomizer() {
        return randomizer;
    }

    public void setRandomizer(Random randomizer) {
        this.randomizer = randomizer;
    }

}
