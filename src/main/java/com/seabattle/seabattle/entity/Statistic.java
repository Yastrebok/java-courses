package com.seabattle.seabattle.entity;

public final class Statistic {

    private static Statistic STATISTIC = null;

    private int amountOfHits = 0;
    private int amountOfShots = 0;


    public Statistic() {
    }


    public static Statistic getStatistic() {
        if (STATISTIC == null) {
            STATISTIC = new Statistic();
        }
            return STATISTIC;
    }

    public int getAmountOfHits() {
        return amountOfHits;
    }

    public void setAmountOfHits(int amountOfHits) {
        this.amountOfHits = amountOfHits;
    }

    public int getAmountOfShots() {
        return amountOfShots;
    }

    public void setAmountOfShots(int amountOfShots) {
        this.amountOfShots = amountOfShots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Statistic statistic = (Statistic) o;

        if (amountOfHits != statistic.amountOfHits) return false;
        return amountOfShots == statistic.amountOfShots;
    }

    @Override
    public int hashCode() {
        int result = amountOfHits;
        result = 31 * result + amountOfShots;
        return result;
    }
}
