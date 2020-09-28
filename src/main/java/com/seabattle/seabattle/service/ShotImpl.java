package com.seabattle.seabattle.service;

import com.seabattle.seabattle.entity.Field;
import com.seabattle.seabattle.entity.Statistic;
import com.seabattle.seabattle.repository.FieldRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShotImpl implements Shot {

    @Autowired
    private FieldRepo fieldRepo;

    @Override
    public void takeShot(String x, Integer y) {
        int quantityOfShots = Statistic.getStatistic().getAmountOfShots();
        int quantityOfHits = Statistic.getStatistic().getAmountOfHits();
        Field requiredFiled = fieldRepo.getFieldById(y);
        Field requiredBattlefield = fieldRepo.getBattlefieldById(y);
        if (x.toUpperCase().equals("A")) {
            if (requiredFiled.getA().equals("ship")) {
                requiredBattlefield.setA("Bang!");
                quantityOfHits++;
            } else {
                requiredBattlefield.setA(".");
                quantityOfShots++;
            }
        } else {
            if (x.toUpperCase().equals("B")) {
                if (requiredFiled.getB().equals("ship")) {
                    requiredBattlefield.setA("Bang!");
                    quantityOfHits++;
                } else {
                    requiredBattlefield.setA(".");
                    quantityOfShots++;
                }
            } else {
                if (x.toUpperCase().equals("C")) {
                    if (requiredFiled.getC().equals("ship")) {
                        requiredBattlefield.setA("Bang!");
                        quantityOfHits++;
                    } else {
                        requiredBattlefield.setA(".");
                        quantityOfShots++;
                    }
                } else {
                    if (x.toUpperCase().equals("D")) {
                        if (requiredFiled.getD().equals("ship")) {
                            requiredBattlefield.setA("Bang!");
                            quantityOfHits++;
                        } else {
                            requiredBattlefield.setA(".");
                            quantityOfShots++;
                        }
                    } else {
                        if (x.toUpperCase().equals("E")) {
                            if (requiredFiled.getE().equals("ship")) {
                                requiredBattlefield.setA("Bang!");
                                quantityOfHits++;
                            } else {
                                requiredBattlefield.setA(".");
                                quantityOfShots++;
                            }
                        }
                    }
                }
            }
        }
        Statistic.getStatistic().setAmountOfHits(quantityOfHits);
        Statistic.getStatistic().setAmountOfShots(quantityOfShots);
        fieldRepo.updateBattlefield(requiredBattlefield);
    }
}