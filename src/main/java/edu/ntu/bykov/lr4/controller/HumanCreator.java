package edu.ntu.bykov.lr4.controller;

import edu.ntu.bykov.lr4.model.Human;
import edu.ntu.bykov.lr4.model.Sex;

public class HumanCreator {

    public Human createHead(String firstName, String lastName, String middleName, Sex sex) {
        return new Human(firstName, lastName, middleName, sex) {};
    }
}
