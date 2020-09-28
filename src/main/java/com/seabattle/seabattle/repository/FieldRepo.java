package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Field;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;


public interface FieldRepo {

    List<Field> getField();
    List<Field> getBattlefield();

    Field getFieldById(Integer id);
    Field getBattlefieldById(Integer id);

    void updateField(Field field);
    void updateBattlefield(Field field);

    void resetShips();

    RowMapper<Field> FIELD_ROW_MAPPER = (ResultSet resultSet, int row) -> {
        Field ship = new Field();
        ship.setId(resultSet.getInt("id"));
        ship.setA(resultSet.getString("a") == null ? "": (resultSet.getString("a")));
        ship.setB(resultSet.getString("b") == null ? "": (resultSet.getString("b")));
        ship.setC(resultSet.getString("c") == null ? "": (resultSet.getString("c")));
        ship.setD(resultSet.getString("d") == null ? "": (resultSet.getString("d")));
        ship.setE(resultSet.getString("e") == null ? "": (resultSet.getString("e")));
        return ship;
    };
}
