package com.gmail.vadimv41.controller;

import com.gmail.vadimv41.model.GameModel;
import com.gmail.vadimv41.statistic.Statistic;
import com.gmail.vadimv41.view.GameView;

import java.util.Scanner;

/**
 * Controller class
 */
public class GameController {

    private GameModel model;
    private GameView view;

    /**
     * Constructor
     * @param model model object
     * @param view view object
     */
    public GameController (GameModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Run the game. Read data from console and analyze it.
     */
    public void startGame() {
        model.generateResultNumber();
        int currentLeftBound;
        int currentRightBound;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        boolean isFinished = false;

        while (!isFinished) {
            currentLeftBound = model.getCurrentLeftBound();
            currentRightBound = model.getCurrentRightBound();
            view.printMessage("Enter number from interval: [" + currentLeftBound + "; " + currentRightBound + "]\n");

            try {
                number = readNumberFromConsole(sc);
                if (number < currentLeftBound || number > currentRightBound) {
                    view.printMessage("Please enter number from interval\n");
                    continue;
                }
                isFinished = checkUserInput(number);
            } catch (Exception e) {
                view.printMessage("Incorect data\n");
                sc.nextLine();
            }

        }
    }

    /**
     * @param number input number
     * @return result of comparison of the entered number with result
     */
    private boolean checkUserInput(int number){
        int result = this.model.checkUserInput(number);

        if (result == 0) {
            view.printMessage("\nYou win!!!!\n");
            Statistic gameStatistic = model.getStatistic();
            view.printStatistic(gameStatistic.getStatistic());
            return true;
        } else if (result == -1) {
            view.printMessage("Input number is smaller then result\n");
            return false;
        } else if (result == 1 ) {
            view.printMessage("Input number is bigger then result\n");
            return false;
        }
        return false;
    }

    /**
     * Read number from console
     * @param sc scanner object
     * @return number from console
     */
    int readNumberFromConsole(Scanner sc) {
        return sc.nextInt();
    }

}
