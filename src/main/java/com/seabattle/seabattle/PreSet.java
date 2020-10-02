package com.seabattle.seabattle;


import com.seabattle.seabattle.repository.FieldRepo;
import com.seabattle.seabattle.repository.ShipRepo;
import com.seabattle.seabattle.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PreSet {

    @Autowired
    FieldRepo fieldRepo;

    @Autowired
    ShipRepo shipRepo;

    @Autowired
    FieldService fieldService;

    @PostConstruct
    void loadPreSetDB() {
        fieldRepo.resetFields();
        shipRepo.setUpShips();
      //  fieldService.fillBattlefielsTable();
    }
}
