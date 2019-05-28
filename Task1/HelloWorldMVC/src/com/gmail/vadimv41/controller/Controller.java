package com.gmail.vadimv41.controller;

import com.gmail.vadimv41.model.Model;
import com.gmail.vadimv41.view.ConsoleView;

import java.util.Scanner;

/**
 * Controller class
 */
public class Controller {

    private ConsoleView view;
    private Model model;

    /**
     * Constructor
     * @param view view object
     * @param model model object
     */
    public Controller(ConsoleView view, Model model) {
        this.view = view;
        this.model = model;
    }

    /**
     * Process user input
     */
    public void processUserInput(){
        Scanner sc = new Scanner(System.in);
        String result;
        view.printMessage("Enter Hello world string: ");
        String messageToPrint = "Enter first word";
        while (!model.checkWholeString()) {
            view.printMessage(messageToPrint);
            result = getStringFromConsole(sc);
            if (model.addFirstWord(result)) {
                messageToPrint = "Please enter second word";
            } else if (model.addSecondWord(result)) {
                messageToPrint = "Second word added";
            } else {
                messageToPrint = "Invalid input";
            }
        }

        view.printMessage("------------\n" + model.getValue());
    }

    /**
     * Getting string from console
     * @param sc scanner object
     * @return input string
     */
    private String getStringFromConsole(Scanner sc) {
        String input = sc.nextLine();
        return input;
    }
}
