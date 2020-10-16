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
            Optional<FieldRow> fieldRow = fieldRepo.getBattlefieldById(y);

            if (requiredShip.isPresent()) {
                quantityOfHits++;
                requiredShip.get().setState(1);
                shipRepo.update(requiredShip.get());
                fieldRepo.updateBattlefield(Utility.updateFieldbyShip(x,y,"Bang!",fieldRow));
            } else {
                quantityOfShots++;
                fieldRepo.updateBattlefield(Utility.updateFieldbyShip(x, y,".", fieldRow));
            }

            Statistic.getStatistic().setAmountOfHits(quantityOfHits);
            Statistic.getStatistic().setAmountOfShots(quantityOfShots);
        }
    }
}