package com.seabattle.seabattle.repository;

import com.seabattle.seabattle.entity.FieldRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class FieldRepoImpl implements FieldRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FieldRow> getField() {
        String query ="select * from field";
        return null;//jdbcTemplate.query(query, FIELD_ROW_MAPPER);
    }

    @Override
    public List<FieldRow> getBattlefield() {
        return jdbcTemplate.query("select * from battlefield", FIELD_ROW_MAPPER);
    }

    @Override
    public FieldRow getFieldById(Integer id) {
        return new FieldRow();//jdbcTemplate.query("SELECT * from testdb.field where id = ?", FIELD_ROW_MAPPER, id).get(0);

    }

    @Override
    public Optional<FieldRow> getBattlefieldById(Integer id) {
        return Optional.of(jdbcTemplate.queryForObject("SELECT * from battlefield where id = ?", FIELD_ROW_MAPPER, id));
    }

    @Override
    public void updateField(FieldRow fieldRow) {
//        String sql = "UPDATE fieldRow SET  a = ?, b = ?, c = ?, d = ?, e = ? WHERE id = ?";
//        jdbcTemplate.update(sql, fieldRow.getA(), fieldRow.getB(), fieldRow.getC(), fieldRow.getD(), fieldRow.getE(), fieldRow.getId());
    }

    @Override
    public void updateBattlefield(FieldRow fieldRow) {
        String sql = "UPDATE battlefield SET  a = ?, b = ?, c = ?, d = ?, e = ? WHERE id = ?";
        jdbcTemplate.update(sql, fieldRow.getA(), fieldRow.getB(), fieldRow.getC(), fieldRow.getD(), fieldRow.getE(), fieldRow.getId());

    }

    @Override
    public void resetFields() {
  //      jdbcTemplate.execute("delete from field where id IN (1, 2, 3, 4, 5)");
        jdbcTemplate.execute("delete from battlefield where id IN (1, 2, 3, 4, 5)");

//        jdbcTemplate.execute("insert into field  values (1, 0, 0, 0, 0, 0), (2, 0, 0, 0, 0, 0), " +
//                "(3, 0, 0, 0, 0, 0), (4, 0, 0, 0, 0, 0), (5, 0, 0, 0, 0, 0)");

        jdbcTemplate.execute("insert into battlefield  values (1, '' , '', '', '', ''), (2, '', '', '', '', ''), " +
                "(3, '', '', '', '', ''), (4, '', '', '', '', ''), (5, '', '', '', '', '')");
    }
}

