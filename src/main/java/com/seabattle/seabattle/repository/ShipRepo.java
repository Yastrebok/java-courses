package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Ship;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;


public interface ShipRepo {

    List<Ship> getShips();

    Optional<Ship> getShipByXY(String x , Integer y);

    void setUpShips();

    void putShip(Ship ship);

    void update(Ship ship);

    RowMapper<Ship> SHIP_MAPPER = (ResultSet resultSet, int row) -> {
        Ship ship = new Ship();
        ship.setId(resultSet.getInt("id"));
        ship.setX(resultSet.getString("x"));
        ship.setY(resultSet.getInt("y"));
        ship.setState(resultSet.getInt("State"));
        return ship;
    };


}
