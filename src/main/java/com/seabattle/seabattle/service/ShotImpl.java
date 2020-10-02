package com.seabattle.seabattle.service;

import com.seabattle.seabattle.entity.FieldRow;
import com.seabattle.seabattle.entity.Ship;
import com.seabattle.seabattle.entity.Statistic;
import com.seabattle.seabattle.repository.FieldRepo;
import com.seabattle.seabattle.repository.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShotImpl implements Shot {

    @Autowired
    FieldRepo fieldRepo;

    @Autowired
    ShipRepo shipRepo;

    @Override
    public void takeShot(String x, Integer y) {
        int quantityOfShots = Statistic.getStatistic().getAmountOfShots();
        int quantityOfHits = Statistic.getStatistic().getAmountOfHits();
        if (x.isEmpty()) {

        } else {

            Optional<Ship> requiredShip = shipRepo.getShipByXY(x, y);

            if (requiredShip.isPresent()) {
                quantityOfHits++;
                requiredShip.get().setState(1);
                shipRepo.update(requiredShip.get());
                fieldRepo.updateBattlefield(updateFieldbyShip(x,y,"Bang!"));
            } else {
                quantityOfShots++;
                fieldRepo.updateBattlefield(updateFieldbyShip(x, y,"."));

            }

            Statistic.getStatistic().setAmountOfHits(quantityOfHits);
            Statistic.getStatistic().setAmountOfShots(quantityOfShots);
        }
    }

    private FieldRow updateFieldbyShip(String x, int y, String str) {
        Optional<FieldRow> fieldRowById = fieldRepo.getBattlefieldById(y);
         x = x.toUpperCase();
        if (fieldRowById.isPresent())
            if (x.equals("A")) {
                fieldRowById.get().setA(str);
            } else {
                if (x.equals("B")) {
                    fieldRowById.get().setB(str);
                } else {
                    if (x.equals("C")) {
                        fieldRowById.get().setC(str);
                    } else {
                        if (x.equals("D")) {
                            fieldRowById.get().setD(str);
                        } else {
                            fieldRowById.get().setE(str);
                        }
                    }
                }
            }
        return fieldRowById.get();
    }
}