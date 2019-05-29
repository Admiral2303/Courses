package com.gmail.vadimv41.main;

import com.gmail.vadimv41.controller.Controller;
import com.gmail.vadimv41.model.Model;
import com.gmail.vadimv41.view.ConsoleView;

public class Main {


    public static void main(String[] args) {
        Model model = new Model();
        ConsoleView view = new ConsoleView();
        Controller controller = new Controller(view, model);
        controller.processUserInput();
    }
}
