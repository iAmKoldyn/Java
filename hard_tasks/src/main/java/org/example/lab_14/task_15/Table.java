package org.example.lab_14.task_15;

import java.util.ArrayList;

public class Table {

    private boolean hasMatches = false;

    private boolean hasTobacco = false;

    private boolean hasPaper = false;

    public boolean hasMatches() {
        return hasMatches;
    }

    public boolean hasTobacco() {
        return hasTobacco;
    }

    public boolean hasPaper() {
        return hasPaper;
    }

    public synchronized Resourse getMatches() {
        if (hasMatches()) {
            hasMatches = false;
            System.out.println("Со стола взяли спички");
            return Resourse.MATCHES;
        } else {
            System.out.println("Взять спички не вышло, их нет");
            return null;
        }
    }

    public synchronized Resourse getTobacco() {
        if (hasTobacco()) {
            hasTobacco = false;
            System.out.println("Со стола взяли табак");
            return Resourse.TOBACCO;
        } else {
            System.out.println("Взять табак не вышло, его нет");
            return null;
        }
    }

    public synchronized Resourse getPaper() {
        if (hasPaper()) {
            hasPaper = false;
            System.out.println("Со стола взяли бумагу");
            return Resourse.PAPER;
        } else {
            System.out.println("Взять бумагу не вышло, её нет");
            return null;
        }
    }

    public void addResources(ArrayList<Resourse> resources) {
        for (Resourse resource : resources) {
            switch (resource) {
                case MATCHES:
                    if (!hasMatches) {
                        System.out.println("На стол положили спички");
                        hasMatches = true;
                    }
                    break;
                case TOBACCO:
                    if (!hasTobacco) {
                        System.out.println("На стол положили табак");
                        hasTobacco = true;
                    }
                    break;
                case PAPER:
                    if (!hasPaper) {
                        System.out.println("На стол положили бумагу");
                        hasPaper = true;
                    }
                    break;
            }
        }
    }
}