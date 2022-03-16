package com.guzanov.spring.dao.dao_interfaces;

import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;

public interface DetailDAO {
    void updateDetail(Detail detail);

    Detail getDetailByID(int detail_id);

    Employee getEmployeeByDetailID(int detail_id);
}
