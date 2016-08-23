package com.github.reka.gson.domain;

import com.github.reka.gson.enumeration.Faction;
import com.github.reka.gson.enumeration.Gender;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author : Chung Junbin
 * @email : <a href="mailto:rekadowney@163.com">发送邮件</a>
 * @createDate : 2016-08-23 16:19
 * @description :
 */
public class Person implements Serializable {

    private String name;
    private Gender gender;
    private Faction faction;
    private LocalDate birthday;

    public Person() {
    }

    public Person(String name, Gender gender, Faction faction, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.faction = faction;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", faction=" + faction +
                ", birthday=" + birthday +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
