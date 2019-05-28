package com.gmail.vadimv41.model;

import java.util.Objects;

/**
 * Model class
 */
public class Model {
    private String value;

    /**
     * Default constructor
     */
    public Model() {
        this.value = "";
    }

    /**
     * Constructor
     * @param value string with phrase
     */
    public Model(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Checks first word from the string and adds to the result if it is right
     * @param valueToAdd first word from the phrase
     * @return result of matches with given string
     */
    public boolean addFirstWord(String valueToAdd) {
        String firstWordRegex = "Hello";
        if (valueToAdd.matches(firstWordRegex) && !value.matches(firstWordRegex)) {
            this.value += valueToAdd;
            return true;
        }
        return false;
    }

    /**
     * Checks second word from the string and adds to the result if it is right
     * @param valueToAdd second word from the phrase
     * @return result of matches with given string
     */
    public boolean addSecondWord(String valueToAdd) {
        String secondWordRegex = "world";
        if (valueToAdd.matches(secondWordRegex)) {
            this.value += ", " + valueToAdd + '!';
            return true;
        }
        return false;
    }

    /**
     * Checks value string to match with "Hello, world!"
     * @return result of matches with given string
     */
    public boolean checkWholeString() {
        String helloWorldRegex = "Hello, world!";
        return value.matches(helloWorldRegex);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(value, model.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
