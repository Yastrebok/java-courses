package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.FieldRow;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;


public interface FieldRepo {

    List<FieldRow> getField();
    List<FieldRow> getBattlefield();

    FieldRow getFieldById(Integer id);
    Optional<FieldRow> getBattlefieldById(Integer id);

    void updateField(FieldRow fieldRow);
    void updateBattlefield(FieldRow fieldRow);

    void resetFields();

    RowMapper<FieldRow> FIELD_ROW_MAPPER = (ResultSet resultSet, int row) -> {
        FieldRow ship = new FieldRow();
        ship.setId(resultSet.getInt("id"));
        ship.setA(resultSet.getString("a"));
        ship.setB(resultSet.getString("b"));
        ship.setC(resultSet.getString("c"));
        ship.setD(resultSet.getString("d"));
        ship.setE(resultSet.getString("e"));
        return ship;
    };
}
