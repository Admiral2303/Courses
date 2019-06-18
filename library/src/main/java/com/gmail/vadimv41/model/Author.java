package com.gmail.vadimv41.model;

import java.time.LocalDate;
import java.util.Objects;

public class Author {
    private String name;
    private String surname;
    private LocalDate birthday;

    public Author(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname) &&
                Objects.equals(birthday, author.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, birthday);
    }
}
