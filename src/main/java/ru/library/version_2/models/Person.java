package ru.library.version_2.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @NotEmpty(message = "Поле не может быть пустым")
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+",
            message = "Корректный формат ФИО: Фамилия Имя Отчество")
    @Size(max = 40, message = "Слишком длинные ФИО")
    @Column(name = "name")
    private String name;

    @Min(value = 1900, message = "Год рождения должен быть после 1900")
    @Column(name = "birth_year")
    private int birthYear;

    public Person(int id, String name, int birthYear) {
        this.personId = id;
        this.name = name;
        this.birthYear = birthYear;
    }

    public Person() {}

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
}
