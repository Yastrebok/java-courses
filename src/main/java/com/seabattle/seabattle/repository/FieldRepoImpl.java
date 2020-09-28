package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class FieldRepoImpl implements FieldRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Field> getField() {
        String query = "select * from field";
        return jdbcTemplate.query(query, FIELD_ROW_MAPPER);
    }

    @Override
    public List<Field> getBattlefield() {
        return jdbcTemplate.query("select * from battlefield",FIELD_ROW_MAPPER);
    }

    @Override
    public Field getFieldById(Integer id) {
        return jdbcTemplate.query("SELECT * from testdb.field where id = ?", FIELD_ROW_MAPPER, id).get(0);

    }

    @Override
    public Field getBattlefieldById(Integer id) {
        return jdbcTemplate.query("SELECT * from battlefield where id = ?", FIELD_ROW_MAPPER, id).get(0);
    }

    @Override
    public void updateField(Field field) {
        String sql = "UPDATE field SET  a = ?, b = ?, c = ?, d = ?, e = ? WHERE id = ?";
        jdbcTemplate.update(sql, field.getA(), field.getB(), field.getC(), field.getD(), field.getE(), field.getId());
    }

    @Override
    public void updateBattlefield(Field field) {
        String sql = "UPDATE battlefield SET  a = ?, b = ?, c = ?, d = ?, e = ? WHERE id = ?";
        jdbcTemplate.update(sql, field.getA(), field.getB(), field.getC(), field.getD(), field.getE(), field.getId());

    }

    @Override
    public void resetShips() {
        jdbcTemplate.execute("delete from field where id IN (1, 2, 3, 4, 5)");
        jdbcTemplate.execute("delete from battlefield where id IN (1, 2, 3, 4, 5)");

        jdbcTemplate.execute("insert into field  values (1, null, null, null, null, null), (2, null, null, null, null, null), " +
                "(3, null, null, null, null, null), (4, null, null, null, null, null), (5, null, null, null, null, null)");

        jdbcTemplate.execute("insert into battlefield  values (1, null, null, null, null, null), (2,  null, null, null, null, null), " +
                "(3, null, null, null, null, null), (4, null, null, null, null, null), (5, null, null, null, null, null)");

        Random random = new Random();
        for (int i = 1; i < 5; i++) {
            Field field = new Field();
            field.setId(random.nextInt(5));
            field.putShip(random.nextInt(5));
            updateField(field);
        }
    }
}
