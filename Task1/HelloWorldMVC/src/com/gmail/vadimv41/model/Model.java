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
