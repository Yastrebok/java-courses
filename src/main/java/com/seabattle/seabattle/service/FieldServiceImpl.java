package com.seabattle.seabattle.service;

import com.seabattle.seabattle.entity.FieldRow;
import com.seabattle.seabattle.entity.Ship;
import com.seabattle.seabattle.repository.FieldRepo;
import com.seabattle.seabattle.repository.ShipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    ShipRepo shipRepo;
    @Autowired
    FieldRepo fieldRepo;


    @Override
    public void fillBattlefielsTable() {
        shipRepo.getShips().stream()
                .map(this::updateFieldbyShip)
                .forEach(fieldRow -> fieldRepo.updateBattlefield(fieldRow));
    }

    private FieldRow updateFieldbyShip(Ship ship) {
        Optional<FieldRow> fieldRowById = Optional.of(new FieldRow());
        fieldRowById = fieldRepo.getBattlefieldById(ship.getY());
        String x = ship.getX().toUpperCase();
        if (fieldRowById.isPresent())
            if (x.equals("A")) {
                fieldRowById.get().setA(x);
            } else {
                if (x.equals("B")) {
                    fieldRowById.get().setB(x);
                } else {
                    if (x.equals("C")) {
                        fieldRowById.get().setC(x);
                    } else {
                        if (x.equals("D")) {
                            fieldRowById.get().setD(x);
                        } else {
                            fieldRowById.get().setE(x);
                        }

                    }
                }
            }
        return fieldRowById.get();
    }
}
