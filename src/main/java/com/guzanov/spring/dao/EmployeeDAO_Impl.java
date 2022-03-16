package com.guzanov.spring.dao;

import com.guzanov.spring.dao.dao_interfaces.EmployeeDAO;
import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Detail;
import com.guzanov.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDAO_Impl implements EmployeeDAO {
    @Autowired
    private SessionFactory factory;


    @Override
    public List<Employee> getAllEmployees() {
        Session session = factory.getCurrentSession();
        List<Employee> employeesList = null;
        try {
            Objects.requireNonNull(employeesList = session.createQuery("from Employee", Employee.class)
                    .getResultList());
        } catch (NullPointerException e) {
            System.out.println("List is NULL. " + e.getMessage());
        }
        return employeesList;
    }

    @Override
    public void saveOrUpdateEmployee(Employee employee) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(employee);
    }


    @Override
    public boolean deleteEmployee(int emp_id) {
        Session session = factory.getCurrentSession();
        Employee employee = session.get(Employee.class, emp_id);
        if (Objects.nonNull(employee)) {
            session.delete(employee);
            return true;
        }
        return false;
    }

    @Override
    public Employee getEmployeeByID(int emp_id) {
        Session session = factory.getCurrentSession();
        Employee employee = session.get(Employee.class, emp_id);
        try {
            Objects.requireNonNull(employee);
        } catch (NullPointerException e) {
            System.out.println("Employee is NULL. " + e.getMessage());
        }
        return employee;
    }

    @Override
    public Detail getEmployeeDetailByID(int emp_id) {
        Session session = factory.getCurrentSession();
        Employee employee;
        Detail detail = null;
        try {
            Objects.requireNonNull(employee = session.get(Employee.class, emp_id));
            try {
                Objects.requireNonNull(detail = employee.getDetail_id());
            } catch (NullPointerException e) {
                System.out.println("Detail is NULL. " + e.getMessage());
            }
        } catch (NullPointerException e) {
            System.out.println("Employee is NULL. " + e.getMessage());
        }
        return detail;
    }

    @Override
    public Department getEmployeeDepartmentByID(int emp_id) {
        Session session = factory.getCurrentSession();
        Employee employee;
        Department department = null;
        try {
            Objects.requireNonNull(employee = session.get(Employee.class, emp_id));
            try {
                Objects.requireNonNull(department = employee.getDepartment());
            } catch (Exception e) {
                System.out.println("Department is NULL. " + e.getMessage());
            }
        } catch (NullPointerException e) {
            System.out.println("Employee is NULL. " + e.getMessage());
        }
        return department;
    }
}
// TODO: 03.03.2022 загрузку сделать не ленивую во всех сущностях !