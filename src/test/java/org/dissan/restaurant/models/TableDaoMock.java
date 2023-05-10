package org.dissan.restaurant.models;

import org.dissan.restaurant.models.dao.TableDao;

import java.util.ArrayList;
import java.util.List;

public class TableDaoMock extends TableDao {
    @Override
    public List<Table> getTables(){
        return new ArrayList<>();
    }
}
