package com.guzanov.spring.dao;

import com.guzanov.spring.dao.dao_interfaces.DetailDAO;
import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class DetailDAO_Impl implements DetailDAO {
    @Autowired
    private SessionFactory factory;


    @Override
    public void updateDetail(Detail detail) {
        Session session = factory.getCurrentSession();
        session.update(detail);
    }

    @Override
    public Detail getDetailByID(int detail_id) {
        Session session = factory.getCurrentSession();
        Detail detail = null;
        try {
            Objects.requireNonNull(detail = session.get(Detail.class, detail_id));
        } catch (Exception e) {
            System.out.println("Detail is NULL. " + e.getMessage());
        }
        return detail;
    }

    @Override
    public Employee getEmployeeByDetailID(int detail_id) {
        Session session = factory.getCurrentSession();
        Detail detail;
        Employee employee = null;
        try {
            Objects.requireNonNull(detail = session.get(Detail.class, detail_id));
            try {
                Objects.requireNonNull(employee = detail.getEmployee());
            } catch (Exception e) {
                System.out.println("Employee is NULL. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Detail is NULL. " + e.getMessage());
        }
        return employee;
    }
}
