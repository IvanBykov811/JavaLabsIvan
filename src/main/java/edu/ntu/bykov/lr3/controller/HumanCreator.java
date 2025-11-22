package edu.ntu.bykov.lr3.controller;

import edu.ntu.bykov.lr3.model.Human;
import edu.ntu.bykov.lr3.model.Sex;

public class HumanCreator {

    public Human createHead(String firstName, String lastName, String middleName, Sex sex) {
        return new Human(firstName, lastName, middleName, sex) {};
    }
}
