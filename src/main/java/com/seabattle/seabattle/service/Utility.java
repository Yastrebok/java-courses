package com.seabattle.seabattle.service;

import com.seabattle.seabattle.entity.FieldRow;
import com.seabattle.seabattle.entity.Ship;
import com.seabattle.seabattle.repository.FieldRepo;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@UtilityClass
class Utility {

    @Autowired
    public FieldRepo fieldRepo;

    FieldRow updateFieldbyShip(String x, int y, String str, Optional<FieldRow> fieldRowById) {
        x = x.toUpperCase();
        updateFieldRow(fieldRowById, x, str);
        return fieldRowById.get();
    }

    FieldRow updateFieldbyShip(Ship ship) {
        Optional<FieldRow> fieldRowById = fieldRepo.getBattlefieldById(ship.getY());
        updateFieldRow(fieldRowById, ship.getX().toUpperCase(), ship.getX().toUpperCase());
        return fieldRowById.get();
    }

    private void updateFieldRow(Optional<FieldRow> fieldRow, String x, String s) {
        if (fieldRow.isPresent())
            if (x.equals("A")) {
                fieldRow.get().setA(s);
            } else {
                if (x.equals("B")) {
                    fieldRow.get().setB(s);
                } else {
                    if (x.equals("C")) {
                        fieldRow.get().setC(s);
                    } else {
                        if (x.equals("D")) {
                            fieldRow.get().setD(s);
                        } else {
                            fieldRow.get().setE(s);
                        }
                    }
                }
            }
    }
}
