package com.gmail.vadimv41.main;

import com.gmail.vadimv41.controller.GameController;
import com.gmail.vadimv41.model.GameModel;
import com.gmail.vadimv41.view.GameView;

public class Main {
    public static void main(String[] args) {
        int startNumber = 0;
        int endNumber = 100;
        GameModel gameModel = new GameModel(startNumber, endNumber);
        GameView gameView = new GameView();
        GameController gameController = new GameController(gameModel, gameView);
        gameController.startGame();
    }
}
