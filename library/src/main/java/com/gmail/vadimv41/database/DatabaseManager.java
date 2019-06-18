package com.gmail.vadimv41.database;

import com.gmail.vadimv41.model.Publication;
import com.gmail.vadimv41.model.ScientificPublication;

import java.time.LocalDate;

public enum DatabaseManager {
    FIRST_PUBLICATION(new ScientificPublication("Romberg integration algorithm", LocalDate.of(2018,3,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            50, "Numerical methods")),
    SECOND_PUBLICATION(new ScientificPublication("Romberg integration algorithm", LocalDate.of(2018,3,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            50, "Numerical methods")),
    THIRD_PUBLICATION(new ScientificPublication("Romberg integration algorithm", LocalDate.of(2018,3,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            50, "Numerical methods")),
    FORTH_PUBLICATION(new ScientificPublication("Romberg integration algorithm", LocalDate.of(2018,3,26),
            "Jacques", "Dutka", LocalDate.of(1970,4,12),
            50, "Numerical methods"));


    private Publication publication;

    DatabaseManager(Publication login) {
        this.publication = publication;
    }

//    /**
//     * Checks if there is login in the database
//     * @param login login to check
//     * @return result of validating the login
//     */
//    public static String isLoginUnique(String login) throws NotUniqueLoginException {
//        for(DatabaseManager value: values()) {
//            if(value.getLogin().equals(login)) {
//                throw new NotUniqueLoginException("Login " + login + " is not unique.", login);
//            }
//        }
//        return login;
//    }

}
