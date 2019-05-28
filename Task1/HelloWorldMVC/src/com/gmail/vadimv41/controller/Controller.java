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
        String result = "";
        view.printMessage("Enter Hello world string: ");
        String messageToPrint = "Enter first word";
        while (!checkWholePhrase(result)) {
            view.printMessage(messageToPrint);
            String input = getStringFromConsole(sc);
            if (checkFirstWord(input, result)) {
                result += input;
                messageToPrint = "Please enter second word";
            } else if (checkSecondWord(input)) {
                result += ", " + input + '!';
                messageToPrint = "Second word added";
                model.setValue(result);
            } else {
                messageToPrint = "Invalid input";
            }
        }
        view.printMessage("------------\n" + model.getValue());
    }

    /**
     * Checks first word from the string and adds to the result if it is right
     * @param toCheck first word from the phrase
     * @param result result string
     * @return result of matches with given string
     */
    private boolean checkFirstWord(String toCheck, String result) {
        String firstWordRegex = "Hello";
        return toCheck.matches(firstWordRegex) && !result.matches(firstWordRegex);
    }

    /**
     * Checks second word from the string and adds to the result if it is right
     * @param toCheck second word from the phrase
     * @return result of matches with given string
     */
    public boolean checkSecondWord(String toCheck) {
        String secondWordRegex = "world";
        return toCheck.matches(secondWordRegex);
    }

    /**
     * Checks value string to match with "Hello, world!"
     * @param toCheck second word from the phrase
     * @return result of matches with given string
     */
    public boolean checkWholePhrase( String toCheck) {
        String helloWorldRegex = "Hello, world!";
        return toCheck.matches(helloWorldRegex);
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
