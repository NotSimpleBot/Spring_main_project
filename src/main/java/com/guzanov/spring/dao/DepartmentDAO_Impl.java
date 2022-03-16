package com.guzanov.spring.dao;

import com.guzanov.spring.dao.dao_interfaces.DepartmentDAO;
import com.guzanov.spring.entity.Department;
import com.guzanov.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Transient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class DepartmentDAO_Impl implements DepartmentDAO {
    @Autowired
    private SessionFactory factory;

    @Transient
    private List<Department> departmentsList = null;

    @Override
    public Map<String, String> getAllDepartments() {
        Session session = factory.getCurrentSession();
        if (Objects.isNull(departmentsList)){
            departmentsList = session.createQuery("from Department ", Department.class)
                    .getResultList();
        }
        System.out.println("0000000");
        departmentsList.forEach(System.out::println);
        Map<String, String> departmentsMap = new HashMap<>();
        for (Department d : departmentsList) {
            departmentsMap.put(d.getId(), d.getId());
        }

        return departmentsMap;
    }

    @Override
    public void updateDepartment(Department department) {
        Session session = factory.getCurrentSession();
        session.saveOrUpdate(department);
    }

    @Override
    public Department getDepartmentByID(String dep_id) {
        Session session = factory.getCurrentSession();
        Department department = null;
        try {
            Objects.requireNonNull(department = session.get(Department.class, dep_id));
        } catch (Exception e) {
            System.out.println("Department is NULL. " + e.getMessage());
        }
        return department;
    }

    @Override
    public List<Employee> getAllEmployeeByDepartmentID(int dep_id) {
        Session session = factory.getCurrentSession();
        Query<Employee> employeeQuery = session.createQuery("from Employee " +
                "where department_id=:depId", Employee.class);
        employeeQuery.setParameter("depId", dep_id);
        return employeeQuery.getResultList();
    }

    @Override
    public List<Department> getAllDepartmentsList() {
        Session session = factory.getCurrentSession();
        List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
        return departments;
    }
}
