package com.gmail.vadimv41.view;

import java.util.ArrayList;

public class GameView {


    public void printMessage(String message){
        System.out.println("-------------------------------------------");
        System.out.print(message);
        System.out.println("-------------------------------------------");
    }

    public void printStatistic(ArrayList<String> statistic) {
        System.out.println("-----------------Statistic-----------------");
        for (String record : statistic) {
            System.out.println(record);
            System.out.println("-------------------------------------------");
        }
    }

}
